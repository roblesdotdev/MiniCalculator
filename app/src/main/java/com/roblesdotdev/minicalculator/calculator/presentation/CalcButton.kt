package com.roblesdotdev.minicalculator.calculator.presentation

sealed class TypeButton {
    object Primary : TypeButton()

    object Secondary : TypeButton()

    object Tertiary : TypeButton()
}

data class CalcButton(
    val symbol: String,
    val span: Int = 1,
    val event: CalculatorEvent,
    val type: TypeButton = TypeButton.Tertiary,
)

val buttons = listOf<CalcButton>(
    CalcButton(symbol = "AC", span = 2, event = CalculatorEvent.Clear, type = TypeButton.Primary),
    CalcButton(symbol = "<", event = CalculatorEvent.Delete, type = TypeButton.Primary),
    CalcButton(
        symbol = "/",
        event = CalculatorEvent.Operation(
            op = CalculatorOp.Divide,
        ),
        type = TypeButton.Secondary,
    ),
    CalcButton(symbol = "7", event = CalculatorEvent.Number(number = 7)),
    CalcButton(symbol = "8", event = CalculatorEvent.Number(number = 8)),
    CalcButton(symbol = "9", event = CalculatorEvent.Number(number = 9)),
    CalcButton(
        symbol = "x",
        event = CalculatorEvent.Operation(op = CalculatorOp.Multiply),
        type = TypeButton.Secondary,
    ),
    CalcButton(symbol = "4", event = CalculatorEvent.Number(number = 4)),
    CalcButton(symbol = "5", event = CalculatorEvent.Number(number = 5)),
    CalcButton(symbol = "6", event = CalculatorEvent.Number(number = 6)),
    CalcButton(
        symbol = "-",
        event = CalculatorEvent.Operation(op = CalculatorOp.Subtract),
        type = TypeButton.Secondary,
    ),
    CalcButton(symbol = "1", event = CalculatorEvent.Number(number = 1)),
    CalcButton(symbol = "2", event = CalculatorEvent.Number(number = 2)),
    CalcButton(symbol = "3", event = CalculatorEvent.Number(number = 3)),
    CalcButton(
        symbol = "+",
        event = CalculatorEvent.Operation(op = CalculatorOp.Add),
        type = TypeButton.Secondary,
    ),
    CalcButton(symbol = "0", span = 2, event = CalculatorEvent.Number(number = 0)),
    CalcButton(symbol = ",", event = CalculatorEvent.Decimal),
    CalcButton(symbol = "=", event = CalculatorEvent.Calculate, type = TypeButton.Secondary),
)
