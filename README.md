# DrawStep — AI Sketch Tutor

Beginner-friendly Android app that teaches drawing through small, progressive steps.

## Status: Phase 1 (foundation)
- Kotlin, Jetpack Compose, Material 3, light and dark themes
- Splash, Home, and a text-only step viewer (Previous / Next / progress)
- One hand-written sample lesson (first 10 "Foundation" steps)
- Unit tests for step navigation and sample lesson data
- No permissions, no internet, no ads, no accounts, no AI yet

## Not built yet
Illustrations for each step, remaining portrait steps, saved progress, drawing canvas,
tracing, photo import, artwork gallery, Urdu text, premium, online AI.
All of these come in later phases. Nothing here is AI generated.

## Layout
- `app/src/main/java/com/drawstep/app/ui` — screens, navigation, theme
- `.../data` — lesson models and sample lesson
- `.../domain` — pure logic (StepNavigator), unit tested
