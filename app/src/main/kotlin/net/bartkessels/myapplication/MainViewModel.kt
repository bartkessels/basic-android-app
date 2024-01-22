package net.bartkessels.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _displayText = MutableStateFlow<MainState>(MainState.Uninitialized)
    val displayText = _displayText.asStateFlow()

    fun updateText() {
        _displayText.update { MainState.Updated }
    }
}

sealed interface MainState {
    data object Uninitialized: MainState
    data object Updated: MainState
}