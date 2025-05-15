package com.roblesdotdev.minicalculator.calculator.presentation

data class CalculatorState(
    val lhs: String = "",
    val rhs: String = "",
    val op: CalculatorOp? = null,
)
