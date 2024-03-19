package net.bartkessels.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private var clickCount = 0
    private val _displayText = MutableStateFlow<MainState>(MainState.Uninitialized)
    val displayText = _displayText.asStateFlow()

    fun updateText() {
        clickCount++
        _displayText.update { MainState.Updated(clickCount) }
    }
}

sealed interface MainState {
    data object Uninitialized: MainState
    data class Updated(val clickCount: Int): MainState
}