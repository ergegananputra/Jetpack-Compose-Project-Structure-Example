package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DahsboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DahsboardRepository
) : ViewModel() {
    private val _state : MutableStateFlow<DashboardState> = MutableStateFlow(DashboardState())
    val state : StateFlow<DashboardState> = _state.asStateFlow()


    fun refresh() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val listOfKajian = withContext(Dispatchers.IO) {
                repository.getAllContent()
            }
            _state.update {
                it.copy(
                    listOfKajian = listOfKajian,
                    isLoading = false
                )
            }
        }
    }
}