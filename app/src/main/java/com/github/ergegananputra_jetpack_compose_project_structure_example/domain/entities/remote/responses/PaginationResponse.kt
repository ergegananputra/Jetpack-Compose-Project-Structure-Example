package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote.responses

import com.google.gson.annotations.SerializedName


abstract class PaginationResponse<DATA>(
    @SerializedName("current_page")
    open var current_page: Int = 0,

    @SerializedName("data")
    open var dataKajian : DATA = null!!,

    @SerializedName("first_page_url")
    open var first_page_url: String = "",

    @SerializedName("from")
    open var from: Int = 0,

    @SerializedName("last_page")
    open var last_page: Int = 0,

    @SerializedName("last_page_url")
    open var last_page_url: String = "",

    @SerializedName("links")
    open var links : List<Link> = emptyList(),

    @SerializedName("next_page_url")
    open var next_page_url: String = "",

    @SerializedName("path")
    open var path: String = "",

    @SerializedName("per_page")
    open var per_page: Int = 0,

    @SerializedName("prev_page_url")
    open var prev_page_url: String = "",

    @SerializedName("to")
    open var to: Int = 0,

    @SerializedName("total")
    open var total: Int = 0
) {

    class Link(
        @SerializedName("url")
        var url: String = "",

        @SerializedName("label")
        var label: String = "",

        @SerializedName("active")
        var active: Boolean = false
    )
}
