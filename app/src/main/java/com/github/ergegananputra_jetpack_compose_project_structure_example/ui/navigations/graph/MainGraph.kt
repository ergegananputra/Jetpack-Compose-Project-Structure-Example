package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.model.ViewModelPacks
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.AboutRoute
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.DashboardRoute
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.RouteDefinition
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.events.OnNavigateAction
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.about.AboutScreen
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard.DashboardScreen

@Stable
@Composable
fun MainGraph(
    viewModelPacks: ViewModelPacks,
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController(),
    onNavigate: (OnNavigateAction, String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = RouteDefinition.Dashboard.route
    ) {
        composable<DashboardRoute> {
             DashboardScreen(
                 viewModel = viewModelPacks.dashboardViewModel,
                 innerPadding = innerPadding,
                 onDetailClick = { hexString ->
                     onNavigate(OnNavigateAction.ON_DETAIL_CLICKED, hexString)
                 }
             )
        }

         composable<AboutRoute> {
            AboutScreen()
        }
    }
}