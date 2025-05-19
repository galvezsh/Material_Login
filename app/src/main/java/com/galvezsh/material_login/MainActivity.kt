package com.galvezsh.material_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.galvezsh.material_login.core.navigation.NavigationWrapper
import com.galvezsh.material_login.ui.theme.MaterialLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialLoginTheme( dynamicColor = false ) {
                NavigationWrapper()
            }
        }
    }
}