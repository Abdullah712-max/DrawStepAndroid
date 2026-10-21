package com.drawstep.app

import com.drawstep.app.domain.StepNavigator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StepNavigatorTest {

    @Test
    fun startsAtStepOne() {
        val nav = StepNavigator(total = 10)
        assertEquals(1, nav.number)
        assertEquals("Step 1 of 10", nav.label)
        assertFalse(nav.canGoPrevious)
        assertTrue(nav.canGoNext)
    }

    @Test
    fun nextAndPreviousMoveOneStep() {
        val nav = StepNavigator(total = 5).next().next()
        assertEquals(3, nav.number)
        assertEquals(2, nav.previous().number)
    }

    @Test
    fun cannotMovePastTheEnds() {
        val first = StepNavigator(total = 3)
        assertEquals(first, first.previous())
        val last = StepNavigator(total = 3, index = 2)
        assertTrue(last.isLast)
        assertEquals(last, last.next())
    }

    @Test
    fun progressIsFractionOfTotal() {
        assertEquals(0.5f, StepNavigator(total = 10, index = 4).progress, 0.0001f)
        assertEquals(1f, StepNavigator(total = 10, index = 9).progress, 0.0001f)
    }

    @Test
    fun jumpToIsClamped() {
        val nav = StepNavigator(total = 10)
        assertEquals(7, nav.jumpTo(7).number)
        assertEquals(1, nav.jumpTo(-4).number)
        assertEquals(10, nav.jumpTo(99).number)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejectsEmptyLessons() {
        StepNavigator(total = 0)
    }
}
