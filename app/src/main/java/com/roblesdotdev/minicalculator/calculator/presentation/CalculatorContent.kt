package com.roblesdotdev.minicalculator.calculator.presentation

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.minicalculator.core.presentation.components.MCButton
import com.roblesdotdev.minicalculator.ui.theme.MiniCalculatorTheme

private const val GRID_CELLS = 4

@Composable
fun CalculatorContent(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    onEvent: (CalculatorEvent) -> Unit,
) {
    val isDarkTheme = isSystemInDarkTheme()
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(48.dp)) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            state.lhs + (state.op?.symbol ?: "") + state.rhs,
            style = MaterialTheme.typography.headlineLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                fontSize = 48.sp,
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            maxLines = 2,
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Fixed(GRID_CELLS),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            buttons.forEach { button ->
                item(span = { GridItemSpan(button.span) }) {
                    val (containerColor, contentColor) = when (button.type) {
                        TypeButton.Primary -> Pair(MaterialTheme.colorScheme.primaryContainer, null)
                        TypeButton.Secondary -> Pair(MaterialTheme.colorScheme.secondaryContainer, null)
                        TypeButton.Tertiary -> {
                            val color =
                                if (!isDarkTheme) MaterialTheme.colorScheme.primary else null
                            Pair(MaterialTheme.colorScheme.tertiaryContainer, color)
                        }
                    }
                    MCButton(
                        symbol = button.symbol,
                        onClick = {
                            onEvent(button.event)
                        },
                        containerColor = containerColor,
                        contentColor = contentColor,
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun CalculatorContentPreview() {
    MiniCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            CalculatorContent(modifier = Modifier.padding(16.dp), state = CalculatorState(lhs = "1,287"), onEvent = {})
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CalculatorContentDarkPreview() {
    MiniCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            CalculatorContent(modifier = Modifier.padding(16.dp), state = CalculatorState(lhs = "1,287"), onEvent = {})
        }
    }
}
