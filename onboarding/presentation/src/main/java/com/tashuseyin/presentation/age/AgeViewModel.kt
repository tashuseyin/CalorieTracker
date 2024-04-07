package com.tashuseyin.presentation.age

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
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {

    var age: String by mutableStateOf("20")
        private set


    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(age: String) {
        if (age.length <= 3) {
            this.age = filterOutDigits.invoke(age)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(UIEvent.ShowSnackbar(UIText.StringResource(R.string.error_age_cant_be_empty)))
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiEvent.send(UIEvent.Navigate(Route.HEIGHT_SCREEN))
        }
    }
}