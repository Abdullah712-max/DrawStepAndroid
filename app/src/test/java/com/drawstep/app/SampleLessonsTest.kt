package com.drawstep.app

import com.drawstep.app.data.SampleLessons
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SampleLessonsTest {

    private val lesson = SampleLessons.portraitFoundation

    @Test
    fun stepsAreNumberedInOrderStartingAtOne() {
        val numbers = lesson.steps.map { it.number }
        assertEquals((1..lesson.steps.size).toList(), numbers)
    }

    @Test
    fun stepTitlesAreUnique() {
        val titles = lesson.steps.map { it.title }
        assertEquals(titles.size, titles.toSet().size)
    }

    @Test
    fun everyStepHasAnInstruction() {
        assertTrue(lesson.steps.all { it.instruction.isNotBlank() })
    }

    @Test
    fun lessonsCanBeFoundById() {
        assertNotNull(SampleLessons.byId("portrait-foundation"))
        assertNull(SampleLessons.byId("does-not-exist"))
    }
}
