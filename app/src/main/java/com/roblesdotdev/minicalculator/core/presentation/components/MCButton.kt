package com.roblesdotdev.minicalculator.core.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.minicalculator.ui.theme.MiniCalculatorTheme

@Composable
fun MCButton(
    modifier: Modifier = Modifier,
    symbol: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
            ).padding(horizontal = 30.dp, vertical = 24.dp)
            .clickable {
                onClick()
            }.then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            symbol,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
            ),
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MCButtonPreview() {
    MiniCalculatorTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(32.dp),
        ) {
            MCButton(
                symbol = "AC",
                onClick = {},
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun MCButtonDarkPreview() {
    MiniCalculatorTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(32.dp),
        ) {
            MCButton(
                symbol = "AC",
                onClick = {},
            )
        }
    }
}
