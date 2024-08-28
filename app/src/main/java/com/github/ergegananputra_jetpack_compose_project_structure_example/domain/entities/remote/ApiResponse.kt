package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote

class ApiResponse <DATA>(
    var status: String = "",
    var message: String = "",
    var data: DATA,
)
