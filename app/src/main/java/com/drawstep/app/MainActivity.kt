package com.drawstep.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.drawstep.app.ui.DrawStepNavHost
import com.drawstep.app.ui.theme.DrawStepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawStepTheme {
                DrawStepNavHost()
            }
        }
    }
}
