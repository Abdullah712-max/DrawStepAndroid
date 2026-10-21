package com.drawstep.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.drawstep.app.data.Lesson
import com.drawstep.app.data.LessonStep
import com.drawstep.app.data.SampleLessons
import com.drawstep.app.domain.StepNavigator

@Composable
fun LessonViewerScreen(lessonId: String, onBack: () -> Unit) {
    val lesson = SampleLessons.byId(lessonId)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        TextButton(onClick = onBack) { Text("\u2190 Back") }
        if (lesson == null) {
            Text(
                text = "This lesson could not be found. Please go back and choose another one.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        } else {
            LessonContent(lesson = lesson, onFinish = onBack)
        }
    }
}

@Composable
private fun ColumnScope.LessonContent(lesson: Lesson, onFinish: () -> Unit) {
    var index by rememberSaveable(lesson.id) { mutableIntStateOf(0) }
    val navigator = StepNavigator(total = lesson.steps.size, index = index)
    val step = lesson.steps[navigator.index]

    Text(
        text = lesson.title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(Modifier.height(4.dp))
    Text(
        text = "${navigator.label}  \u2022  ${step.section}",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary
    )
    Spacer(Modifier.height(8.dp))
    LinearProgressIndicator(
        progress = { navigator.progress },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(Modifier.height(16.dp))

    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        StepCard(step)
    }

    Spacer(Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButton(
            onClick = { index = navigator.previous().index },
            enabled = navigator.canGoPrevious,
            modifier = Modifier.weight(1f)
        ) { Text("Previous") }
        Button(
            onClick = {
                if (navigator.isLast) onFinish() else index = navigator.next().index
            },
            modifier = Modifier.weight(1f)
        ) { Text(if (navigator.isLast) "Finish" else "Next") }
    }
}

@Composable
private fun StepCard(step: LessonStep) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            text = step.title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = step.instruction,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        InfoBox(label = "Illustration", body = "The drawn picture for this step arrives in Phase 2.")
        step.tip?.let { InfoBox(label = "Tip", body = it) }
        step.commonMistake?.let { InfoBox(label = "Common mistake", body = it) }
    }
}

@Composable
private fun InfoBox(label: String, body: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(14.dp)
    ) {
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
