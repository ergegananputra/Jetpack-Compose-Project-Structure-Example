package com.github.ergegananputra_jetpack_compose_project_structure_example.data.remote


import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote.ApiResponse
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote.responses.GetKajianResponse
import retrofit2.Call
import retrofit2.http.GET


interface WebContentCollaborationApiService {
    @GET("kajian-api")
    fun getAllContent() : Call<ApiResponse<GetKajianResponse>>
}