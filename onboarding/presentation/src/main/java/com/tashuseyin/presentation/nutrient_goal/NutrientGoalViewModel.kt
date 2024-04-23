package com.tashuseyin.presentation.nutrient_goal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tashuseyin.core.domain.preferences.Preferences
import com.tashuseyin.core.domain.use_case.FilterOutDigits
import com.tashuseyin.core.navigation.Route
import com.tashuseyin.core.util.UIEvent
import com.tashuseyin.domain.use_case.ValidateNutrients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {

    private val _uiState: MutableStateFlow<NutrientGoalState> =
        MutableStateFlow(NutrientGoalState())
    val uiState: StateFlow<NutrientGoalState> = _uiState.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when (event) {
            is NutrientGoalEvent.OnCarbRatioEnter -> {
                _uiState.update { state -> state.copy(carbsRatio = filterOutDigits(event.ratio)) }
            }

            is NutrientGoalEvent.OnProteinRatioEnter -> {
                _uiState.update { state -> state.copy(proteinRatio = filterOutDigits(event.ratio)) }
            }

            is NutrientGoalEvent.OnFatRatioEnter -> {
                _uiState.update { state -> state.copy(fatRatio = filterOutDigits(event.ratio)) }
            }

            is NutrientGoalEvent.OnNextClick -> {
                val result = validateNutrients.invoke(
                    _uiState.value.carbsRatio,
                    _uiState.value.proteinRatio,
                    _uiState.value.fatRatio
                )
                when (result) {
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbRatio(result.carbsRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UIEvent.Navigate(Route.TRACKER_OVERVIEW_SCREEN))
                        }
                    }
                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UIEvent.ShowSnackbar(result.message))
                        }
                    }
                }
            }
        }
    }


}