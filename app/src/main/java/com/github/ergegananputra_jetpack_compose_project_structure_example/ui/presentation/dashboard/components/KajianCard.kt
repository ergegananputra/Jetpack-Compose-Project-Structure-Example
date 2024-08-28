package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.github.ergegananputra_jetpack_compose_project_structure_example.R

@Stable
@Composable
fun KajianCard(
    judul: String,
    pemateri: String,
    deskripsi: String,
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    var isOverFlowEnabled by rememberSaveable {
        mutableStateOf(false)
    }
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }


    Surface(
        shape = RoundedCornerShape(16.dp),
        color = colorScheme.surfaceContainer,
        contentColor = colorScheme.onSurface,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 0.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxWidth()
            ) {
                SubcomposeAsyncImage(
                    model = imageURL,
                    contentDescription = "Image $judul",
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    error = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Error Image"
                        )
                    },
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = judul,
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                fontSize = typography.titleLarge.fontSize,
            )

            Text(
                text = pemateri,
                maxLines = 1,
                fontSize = typography.labelSmall.fontSize,
                textAlign = TextAlign.End
            )

            Text(
                text = deskripsi,
                maxLines = if(isExpanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = typography.bodySmall.fontSize,
                onTextLayout = {
                    if (it.hasVisualOverflow) {
                        isOverFlowEnabled = true
                    }
                }
            )

            if (isOverFlowEnabled) {
                Text(
                    text = if(isExpanded) "Lihat lebih sedikit" else "Baca selengkapnya",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = typography.labelSmall.fontSize,
                    modifier = Modifier
                        .clickable {
                            isExpanded = !isExpanded
                        }
                )
            }
        }
    }
}