package com.github.ergegananputra_jetpack_compose_project_structure_example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.constants.IntentKeys
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.model.ViewModelPacks
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.BottomNavigationState
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.MenuNavigationController
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.events.OnNavigateAction
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.graph.MainGraph
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.components.BottomAppBar
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.components.TopAppBar
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard.DashboardViewModel
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.detail.DetailActivity
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val detailActivityOnResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Log.d("MainActivity", "Exit DetailActivity with result OK")
        } else {
            Toast.makeText(this, "Terjadi Kesalahan Sistem", Toast.LENGTH_SHORT).show()
            Log.e("MainActivity", "Exit DetailActivity with result CANCELED")
        }
    }

    private val menuController by lazy { MenuNavigationController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        enableEdgeToEdge()
        setContent {
            val viewModelPacks = ViewModelPacks(
                dashboardViewModel = hiltViewModel<DashboardViewModel>()
            )

            var bottomNavigationState by remember {
                mutableStateOf(BottomNavigationState())
            }

            val navController = rememberNavController()

            DependencyInjectionTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                         TopAppBar()
                    },
                    bottomBar = {
                         BottomAppBar(
                             state = bottomNavigationState,
                             menu = menuController.menus,
                             onMenuSelectedListener = { menu ->
                                 bottomNavigationState = bottomNavigationState.copy(currentRoute = menu.route)

                                 if (menu.route.route != navController.currentDestination?.route) {
                                    navController.popBackStack(
                                        navController.graph.startDestinationId,
                                        false
                                    )
                                 }
                             }
                         )
                    }
                ) { innerPadding ->
                    MainGraph(
                        viewModelPacks = viewModelPacks,
                        innerPadding = innerPadding,
                        onNavigate = { action, arg ->
                            onNavigate(action, arg)
                        },
                        navController = navController
                    )
                }
            }

            LaunchedEffect(key1 = bottomNavigationState) {
                try {
                    navController.navigate(bottomNavigationState.currentRoute.route)
                } catch (e: IllegalStateException) {
                    Log.e("MainActivity", "Failed to navigate to ${bottomNavigationState.currentRoute.route}")
                } catch (e: Exception) {
                    Log.e("MainActivity", "Failed to navigate to ${bottomNavigationState.currentRoute.route}, ${e.message}")
                }
            }
        }
    }

    private fun openDetailActivity(hexString: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(IntentKeys.HEXSTRING_DETAIL_ID.name, hexString)
        detailActivityOnResult.launch(intent)
    }

    private fun onNavigate(action: OnNavigateAction, arg: String) {
        when (action) {
            OnNavigateAction.ON_DETAIL_CLICKED -> {
                openDetailActivity(arg)
            }
            else -> {
                Log.e("MainActivity", "Unknown action: $action")
            }
        }
    }
}
