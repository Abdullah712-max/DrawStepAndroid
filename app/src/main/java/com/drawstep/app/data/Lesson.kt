package com.drawstep.app.data

enum class Difficulty(val label: String) {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced")
}

data class LessonStep(
    val number: Int,
    val section: String,
    val title: String,
    val instruction: String,
    val tip: String? = null,
    val commonMistake: String? = null
)

data class Lesson(
    val id: String,
    val title: String,
    val category: String,
    val difficulty: Difficulty,
    val summary: String,
    val steps: List<LessonStep>
)
