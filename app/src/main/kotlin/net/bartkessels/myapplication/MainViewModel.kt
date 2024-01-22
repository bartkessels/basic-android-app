package net.bartkessels.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _displayText = MutableStateFlow("Hello World!")
    val displayText = _displayText.asStateFlow()

    fun updateText() {
        _displayText.update { "Hello again!" }
    }
}