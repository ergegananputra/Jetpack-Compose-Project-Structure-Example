package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.extensions.fromHTMLtoString
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme
import com.github.ergegananputra_jetpack_compose_project_structure_example.zetsdevelopment.Mocks

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun DetailScreenDeveloperPreview() {
    DependencyInjectionTheme {
        DetailScreen(
            viewModel = DetailViewModel(Mocks.dashBoardRepository)
        )
    }
}


@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    modifier : Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    val imagePainter = rememberAsyncImagePainter(model = state.fotoKajian)
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Surface(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp)
        ) {
            Text(text = "Detail Screen", style = typography.titleMedium)
            Image(
                painter = imagePainter,
                contentDescription = "Image ${state.judulKajian}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "Image from ${state.fotoKajian}",
                                Toast.LENGTH_LONG
                            )
                            .show()
                    }
            )

            Text(
                text = state.slug ?: "",
                style = typography.labelMedium,
            )

            Text(
                text = state.pemateri ?: "",
                style = typography.labelMedium,
            )

            Text(
                text = state.judulKajian ?: "",
                style = typography.titleMedium,
            )

            Text(
                text = state.deskripsiKajian?.fromHTMLtoString() ?: "",
                style = typography.bodyMedium,
            )
        }
    }
}

