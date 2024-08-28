package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian

data class DashboardState(
    val isLoading : Boolean = false,
    val listOfKajian : List<Kajian> = emptyList(),
    val errorMessage : String? = null,
)
