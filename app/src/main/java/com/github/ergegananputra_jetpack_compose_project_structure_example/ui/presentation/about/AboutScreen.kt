package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun AboutScreenDeveloperPreview() {
    DependencyInjectionTheme {
        AboutScreen()
    }
}


@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "About Screen",
                style = typography.displayMedium
            )
        }
    }
}