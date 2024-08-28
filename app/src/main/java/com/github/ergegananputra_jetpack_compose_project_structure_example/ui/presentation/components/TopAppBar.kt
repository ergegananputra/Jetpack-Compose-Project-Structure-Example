package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ergegananputra_jetpack_compose_project_structure_example.R
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme

@Preview(
    name = "Light Mode",
)
@Preview(
    name = "Dark Mode",
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DITopAppBarDeveloperPreview() {
    DependencyInjectionTheme {
        TopAppBar(
            trailingIcon = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Pesan",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                }
            }
        )
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    notchHeight : Dp = 24.dp,
    title : String = stringResource(id = R.string.app_name),
    trailingIcon : @Composable () -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = notchHeight,
                    start = 4.dp,
                    end = 4.dp,
                    bottom = 4.dp
                )
                .height(64.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "DI Logo",
                    colorFilter = tint(MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(15.dp)
                )
            }


            Text(
                text = title.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
            )

            trailingIcon()
        }
    }
}