package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.detail

import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.constants.IntentKeys
import com.github.ergegananputra_jetpack_compose_project_structure_example.ui.theme.DependencyInjectionTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get intent hexString detail id
        val hexString = intent.getStringExtra(IntentKeys.HEXSTRING_DETAIL_ID.name) ?: run {
            Log.e("DetailActivity", "No hexString found in intent")
            setResult(RESULT_CANCELED)
            finish()
            return
        }


        enableEdgeToEdge()
        setContent {
            val detailViewModel = hiltViewModel<DetailViewModel>()
            detailViewModel.getDetail(hexString)

            DependencyInjectionTheme {
                Scaffold {
                    DetailScreen(
                        viewModel = detailViewModel,
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        setResult(RESULT_OK)
        return super.getOnBackInvokedDispatcher()
    }
}