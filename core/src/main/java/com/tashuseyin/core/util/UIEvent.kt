package com.tashuseyin.core.util

sealed class UIEvent {
    data class Navigate(val route: String) : UIEvent()
    data object NavigateUp: UIEvent()
    data class ShowSnackbar(val message: UIText): UIEvent()
}