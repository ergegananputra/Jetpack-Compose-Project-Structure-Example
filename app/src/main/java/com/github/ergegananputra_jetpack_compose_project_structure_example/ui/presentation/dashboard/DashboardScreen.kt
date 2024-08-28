package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.constants.HOST
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.extensions.fromHTMLtoString
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard.components.KajianCard
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme
import com.github.ergegananputra_jetpack_compose_project_structure_example.zetsdevelopment.Mocks

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun DashboardScreenDeveloperPreview() {
    DependencyInjectionTheme {
        DashboardScreen(
            viewModel = DashboardViewModel(Mocks.repository),
            innerPadding = PaddingValues(0.dp),
            onDetailClick = { _ -> }
        )
    }
}


@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    innerPadding: PaddingValues,
    onDetailClick: (String) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    viewModel.refresh()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp)
        ) {
            Text(
                text = "List Kajian",
                fontWeight = FontWeight.Bold,
                fontSize = typography.titleLarge.fontSize,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(
                    state.listOfKajian,
                    key = {
                        it.id.toHexString()
                    }
                ) { kajian ->
                    KajianCard(
                        judul = kajian.judulKajian ?: "Judul",
                        pemateri = kajian.pemateri ?: "Pemateri",
                        deskripsi = kajian.deskripsiKajian?.fromHTMLtoString() ?: "Deskripsi",
                        imageURL = "${HOST}storage/${kajian.fotoKajian}",
                        modifier = Modifier
                            .padding(
                                bottom = 16.dp
                            )
                            .clickable { onDetailClick(kajian.id.toHexString()) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    }
}

