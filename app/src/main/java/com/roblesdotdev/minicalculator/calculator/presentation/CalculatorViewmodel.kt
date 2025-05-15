package com.roblesdotdev.minicalculator.calculator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewmodel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            CalculatorEvent.Calculate -> performCalculation()
            CalculatorEvent.Clear -> state = CalculatorState()
            CalculatorEvent.Decimal -> enterDecimal()
            CalculatorEvent.Delete -> performDeletion()
            is CalculatorEvent.Number -> enterNumber(event.number)
            is CalculatorEvent.Operation -> enterOperation(event.op)
        }
    }

    private fun performCalculation() {
        val lhs = state.lhs.replace(",", ".").toDoubleOrNull()
        val rhs = state.rhs.replace(",", ".").toDoubleOrNull()
        if (lhs == null || rhs == null) return
        val result = when (state.op) {
            CalculatorOp.Add -> lhs + rhs
            CalculatorOp.Divide -> if (rhs == 0.0) 0.0 else lhs / rhs
            CalculatorOp.Multiply -> lhs * rhs
            CalculatorOp.Subtract -> lhs - rhs
            null -> return
        }
        state = state.copy(
            lhs = formatResult(result),
            rhs = "",
            op = null,
        )
    }

    private fun enterDecimal() {
        if (state.op == null && !state.lhs.contains(",") && state.lhs.isNotBlank()) {
            state = state.copy(
                lhs = state.lhs + ",",
            )
            return
        }
        if (!state.rhs.contains(",") && state.rhs.isNotBlank()) {
            state = state.copy(
                rhs = state.rhs + ",",
            )
        }
    }

    private fun enterOperation(op: CalculatorOp) {
        if (state.lhs.isNotBlank()) {
            state = state.copy(op = op)
        }
    }

    private fun performDeletion() {
        when {
            state.rhs.isNotBlank() -> state = state.copy(rhs = state.rhs.dropLast(1))
            state.op != null -> state = state.copy(op = null)
            state.lhs.isNotBlank() -> state = state.copy(lhs = state.lhs.dropLast(1))
        }
    }

    private fun enterNumber(number: Int) {
        if (state.op == null) {
            return enterLHS(number)
        }
        return enterRHS(number)
    }

    private fun enterRHS(number: Int) {
        if (state.rhs.length >= MAX_NUM_LENGTH) {
            return
        }

        state = state.copy(
            rhs = state.rhs + number,
        )
    }

    private fun enterLHS(number: Int) {
        if (state.lhs.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            lhs = state.lhs + number,
        )
    }

    private fun formatResult(value: Double): String =
        if (value % 1.0 == 0.0) {
            value.toInt().toString()
        } else {
            value.toString()
        }.replace(".", ",")

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}
