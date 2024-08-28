package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.model

import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.RouteDefinition

data class BottomAppBarMenu(
    val title: String,
    val icon: Int,
    val iconActive: Int,
    val route: RouteDefinition
) {
    fun icons(isActive: Boolean) = if (isActive) iconActive else icon
}
