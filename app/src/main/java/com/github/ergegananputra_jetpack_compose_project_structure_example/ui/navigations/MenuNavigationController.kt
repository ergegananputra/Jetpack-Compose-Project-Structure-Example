package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.navigations


import com.github.ergegananputra_jetpack_compose_project_structure_example.R
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.model.BottomAppBarMenu

class MenuNavigationController {

    val menus = listOf(
        BottomAppBarMenu(
            title = "Home",
            icon = R.drawable.ic_home,
            iconActive = R.drawable.ic_home_active,
            route = RouteDefinition.Dashboard
        ),
        BottomAppBarMenu(
            title = "About",
            icon = R.drawable.ic_question_mark,
            iconActive = R.drawable.ic_question_mark,
            route = RouteDefinition.About
        )
    )
}