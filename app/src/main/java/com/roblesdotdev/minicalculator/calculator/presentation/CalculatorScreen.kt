package com.roblesdotdev.minicalculator.calculator.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewmodel,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        CalculatorContent(
            modifier = Modifier.padding(innerPadding).padding(16.dp),
            state = viewModel.state,
            onEvent = {
                viewModel.onEvent(it)
            },
        )
    }
}
