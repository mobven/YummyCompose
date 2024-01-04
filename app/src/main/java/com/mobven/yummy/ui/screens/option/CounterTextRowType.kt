package com.mobven.yummy.ui.screens.option

import com.mobven.designsystem.components.buttons.CounterButtonType


sealed interface CounterTextRowType {
    data class CounterButton(val counterButtonType: CounterButtonType) : CounterTextRowType
    data object CircularCounterButton : CounterTextRowType
}