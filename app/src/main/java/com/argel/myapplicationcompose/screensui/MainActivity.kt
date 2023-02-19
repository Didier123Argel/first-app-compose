package com.argel.myapplicationcompose.screensui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import com.argel.myapplicationcompose.navigation.appnavigation.AppNavigation
import com.argel.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme(dynamicColor = false) {
                AppNavigation()
            }
        }
    }
}
