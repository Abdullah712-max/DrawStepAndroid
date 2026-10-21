package com.drawstep.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.drawstep.app.data.Lesson
import com.drawstep.app.data.SampleLessons
import com.drawstep.app.ui.theme.CardGradient

private data class ModeInfo(val name: String, val description: String, val phase: String)

private val upcomingModes = listOf(
    ModeInfo("Tracing Studio", "Trace a reference with adjustable opacity.", "Phase 4"),
    ModeInfo("Practice Canvas", "Freehand drawing with undo and save.", "Phase 3"),
    ModeInfo("Construction Guides", "Learn head construction and proportions.", "Phase 5"),
    ModeInfo("Reference Comparison", "Compare your drawing beside a reference.", "Phase 5"),
    ModeInfo("Photo Import", "Pick a photo with the system photo picker.", "Phase 4"),
    ModeInfo("Online AI Lessons", "Optional, with consent. Needs a secure backend.", "Later")
)

@Composable
fun HomeScreen(onOpenLesson: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Column {
                Text(
                    text = "Welcome to DrawStep",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Turn a hard drawing into small, clear steps.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        item { SectionTitle("Start a lesson") }
        items(SampleLessons.all) { lesson ->
            LessonCard(lesson = lesson, onClick = { onOpenLesson(lesson.id) })
        }
        item { SectionTitle("Coming soon") }
        items(upcomingModes) { mode -> ModeRow(mode) }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
private fun LessonCard(lesson: Lesson, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CardGradient)
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Text(
            text = "${lesson.category}  \u2022  ${lesson.difficulty.label}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.85f)
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = lesson.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = lesson.summary,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "${lesson.steps.size} steps  \u2022  Tap to open",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.85f)
        )
    }
}

@Composable
private fun ModeRow(mode: ModeInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = mode.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = mode.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Text(
            text = mode.phase,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}
