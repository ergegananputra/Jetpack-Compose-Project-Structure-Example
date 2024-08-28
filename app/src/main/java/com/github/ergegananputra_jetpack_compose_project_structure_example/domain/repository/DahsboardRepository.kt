package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian

interface DahsboardRepository {
    suspend fun getAllContent() : List<Kajian>
}