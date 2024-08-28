package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote.responses

import com.google.gson.annotations.SerializedName

data class GetKajianResponse(
    @SerializedName("current_page")
    val currentPage: Int,

    @SerializedName("data")
    val data: List<KajianResponse>,

    @SerializedName("first_page_url")
    val firstPageUrl: String,

    @SerializedName("from")
    val from: Int,

    @SerializedName("last_page")
    val lastPage: Int,

    @SerializedName("last_page_url")
    val lastPageUrl: String,

    @SerializedName("links")
    val links: List<PaginationResponse.Link>,

    @SerializedName("next_page_url")
    val nextPageUrl: String,

    @SerializedName("path")
    val path: String,

    @SerializedName("per_page")
    val perPage: Int,

    @SerializedName("prev_page_url")
    val prevPageUrl: String?,

    @SerializedName("to")
    val to: Int,

    @SerializedName("total")
    val total: Int
)