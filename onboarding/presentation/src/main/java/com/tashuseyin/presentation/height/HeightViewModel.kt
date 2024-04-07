package com.tashuseyin.presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tashuseyin.core.R
import com.tashuseyin.core.domain.preferences.Preferences
import com.tashuseyin.core.domain.use_case.FilterOutDigits
import com.tashuseyin.core.navigation.Route
import com.tashuseyin.core.util.UIEvent
import com.tashuseyin.core.util.UIText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {

    var height: String by mutableStateOf("180")
        private set


    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(height: String) {
        if (height.length <= 3) {
            this.height = filterOutDigits.invoke(height)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(UIEvent.ShowSnackbar(UIText.StringResource(R.string.error_height_cant_be_empty)))
                return@launch
            }
            preferences.saveHeight(heightNumber)
            _uiEvent.send(UIEvent.Navigate(Route.WEIGHT_SCREEN))
        }
    }
}