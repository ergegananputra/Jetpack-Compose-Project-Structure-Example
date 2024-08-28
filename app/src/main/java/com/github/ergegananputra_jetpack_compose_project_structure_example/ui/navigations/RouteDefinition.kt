package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations

import kotlinx.serialization.Serializable

enum class RouteDefinition(val route: Any) {
    Dashboard(DashboardRoute),
    About(AboutRoute),
}

@Serializable object DashboardRoute
@Serializable object AboutRoute