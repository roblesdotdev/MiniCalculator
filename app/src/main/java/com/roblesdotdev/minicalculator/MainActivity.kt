package com.roblesdotdev.minicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.roblesdotdev.minicalculator.calculator.presentation.CalculatorScreen
import com.roblesdotdev.minicalculator.calculator.presentation.CalculatorViewmodel
import com.roblesdotdev.minicalculator.ui.theme.MiniCalculatorTheme

class MainActivity : ComponentActivity() {
    val calcViewModel by viewModels<CalculatorViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniCalculatorTheme {
                CalculatorScreen(viewModel = calcViewModel)
            }
        }
    }
}
