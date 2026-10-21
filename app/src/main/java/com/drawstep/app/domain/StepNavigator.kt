package com.drawstep.app.domain

/**
 * Pure logic for moving through a lesson's steps.
 * Kept free of Android code so it can be unit tested.
 */
data class StepNavigator(val total: Int, val index: Int = 0) {

    init {
        require(total > 0) { "A lesson needs at least one step." }
        require(index in 0 until total) { "Step index $index is outside 0..${total - 1}." }
    }

    val number: Int get() = index + 1
    val canGoPrevious: Boolean get() = index > 0
    val canGoNext: Boolean get() = index < total - 1
    val isLast: Boolean get() = !canGoNext
    val progress: Float get() = number.toFloat() / total
    val label: String get() = "Step $number of $total"

    fun next(): StepNavigator = if (canGoNext) copy(index = index + 1) else this

    fun previous(): StepNavigator = if (canGoPrevious) copy(index = index - 1) else this

    /** Jumps to a 1-based step number, clamped to the valid range. */
    fun jumpTo(stepNumber: Int): StepNavigator =
        copy(index = (stepNumber - 1).coerceIn(0, total - 1))
}
