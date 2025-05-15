package com.roblesdotdev.minicalculator.calculator.presentation

sealed class CalculatorOp(
    val symbol: String,
) {
    object Add : CalculatorOp("+")

    object Subtract : CalculatorOp("-")

    object Multiply : CalculatorOp("x")

    object Divide : CalculatorOp("/")
}
