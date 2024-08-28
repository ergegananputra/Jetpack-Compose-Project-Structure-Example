package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.extensions

import androidx.core.text.HtmlCompat

fun String.fromHTMLtoString(): String {
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
}