package com.mu54omd.sup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

open class BaseViewModel: ViewModel() {
    val scope: CoroutineScope = viewModelScope
}