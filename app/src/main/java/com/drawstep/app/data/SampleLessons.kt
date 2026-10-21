package com.drawstep.app.data

/**
 * Curated, hand-written sample lesson (NOT AI generated).
 * Phase 1 contains the first 10 "Foundation" steps as text only.
 * Phase 2 adds original drawn illustrations and the remaining steps.
 */
object SampleLessons {

    val portraitFoundation = Lesson(
        id = "portrait-foundation",
        title = "Portrait: Head Foundation",
        category = "Human portraits",
        difficulty = Difficulty.BEGINNER,
        summary = "Build the head, neck and shoulders from simple guidelines.",
        steps = listOf(
            LessonStep(
                number = 1,
                section = "Foundation",
                title = "Prepare the drawing area",
                instruction = "Put your paper on a flat surface with good light. Have an HB pencil and a soft eraser ready. Stand your phone upright against something stable, such as a book or mug, so you can see it without holding it.",
                tip = "Keep the phone away from the edge of the table.",
                commonMistake = "Holding the phone in one hand while drawing makes your lines shaky."
            ),
            LessonStep(
                number = 2,
                section = "Foundation",
                title = "Draw a light circle",
                instruction = "Near the upper middle of the page, draw a circle about the size of your palm. This circle is the skull. Draw it very lightly.",
                tip = "Move your whole arm, not just your wrist, and turn the paper as you go.",
                commonMistake = "Pressing hard. Light lines are easy to erase and adjust later."
            ),
            LessonStep(
                number = 3,
                section = "Foundation",
                title = "Flatten the sides of the circle",
                instruction = "Lightly slice a little off the left and right sides of the circle with two gentle, nearly vertical curves. A real head is narrower from side to side than it is round.",
                tip = "Keep both slices the same distance from the centre.",
                commonMistake = "Cutting too much off. Take only a small slice from each side."
            ),
            LessonStep(
                number = 4,
                section = "Foundation",
                title = "Add the vertical centerline",
                instruction = "Draw a light, slightly curved line straight down the middle of the circle and extend it below the circle. It shows which way the face is pointing.",
                tip = "A curved line makes the head look round instead of flat.",
                commonMistake = "Drawing the line perfectly straight, which makes the face look flat."
            ),
            LessonStep(
                number = 5,
                section = "Foundation",
                title = "Add the eye-level guideline",
                instruction = "Draw a gentle horizontal curve across the middle of the circle, crossing the centerline. This is the eye line, and the eyes will sit on it later.",
                tip = "The eyes are about halfway down the whole head, lower than most beginners expect.",
                commonMistake = "Placing the eye line too high, near the top of the head."
            ),
            LessonStep(
                number = 6,
                section = "Foundation",
                title = "Mark the nose guideline",
                instruction = "Draw a short curve across the centerline at the bottom edge of the circle. This marks the base of the nose.",
                tip = "Keep it short. It is only a marker, not a full line across the face.",
                commonMistake = "Making the line too long and too dark, so it is hard to hide later."
            ),
            LessonStep(
                number = 7,
                section = "Foundation",
                title = "Mark the mouth guideline",
                instruction = "Below the nose line, make a small mark on the centerline about one third of the way down towards where the chin will be. This is where the mouth opening will go.",
                tip = "Use a small tick mark instead of a long line.",
                commonMistake = "Putting the mouth too close to the nose."
            ),
            LessonStep(
                number = 8,
                section = "Foundation",
                title = "Define the jawline",
                instruction = "Mark the chin on the centerline, about as far below the nose line as the nose line is below the eye line. Then draw soft lines from the sides of the circle, around ear height, down to the chin to form the jaw.",
                tip = "A softer chin point looks natural. A very sharp one looks cartoonish.",
                commonMistake = "Making the jaw too wide, so the head looks like a box."
            ),
            LessonStep(
                number = 9,
                section = "Foundation",
                title = "Add the neck",
                instruction = "From just inside the jaw on each side, draw two lines down. Keep them roughly parallel, and make the neck about two thirds as wide as the head.",
                tip = "Start the neck slightly behind the jaw, not at the very front.",
                commonMistake = "Drawing the neck too thin. It is wider than it looks."
            ),
            LessonStep(
                number = 10,
                section = "Foundation",
                title = "Establish the shoulders",
                instruction = "At the bottom of the neck, draw two gentle sloping lines outward and downward. The shoulders should be clearly wider than the head.",
                tip = "Slope the shoulders slightly, because flat shoulders look stiff.",
                commonMistake = "Making the shoulders as narrow as the head."
            )
        )
    )

    val all: List<Lesson> = listOf(portraitFoundation)

    fun byId(id: String): Lesson? = all.firstOrNull { it.id == id }
}
