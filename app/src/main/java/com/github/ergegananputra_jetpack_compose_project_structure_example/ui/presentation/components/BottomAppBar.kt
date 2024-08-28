package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.components

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.model.BottomAppBarMenu
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations.BottomNavigationState
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun BottomAppBarDeveloperPreview() {
    DependencyInjectionTheme {
        BottomAppBar()
    }
}


@Composable
fun BottomAppBar(
    state: BottomNavigationState = BottomNavigationState(),
    menu : List<BottomAppBarMenu> = listOf(),
    onMenuSelectedListener : (BottomAppBarMenu) -> Unit = {}
) {
    NavigationBar {
        menu.forEach {
            val selected = state.currentRoute.route == it.route.route
            Log.d("BottomAppBar", "Selected ${it.route}: $selected")
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onMenuSelectedListener(it)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icons(selected)),
                        contentDescription = it.title
                    )
                }
            )
        }
    }
}