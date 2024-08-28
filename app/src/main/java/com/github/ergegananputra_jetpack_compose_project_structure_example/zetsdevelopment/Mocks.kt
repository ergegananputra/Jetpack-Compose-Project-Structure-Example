package com.github.ergegananputra_jetpack_compose_project_structure_example.zetsdevelopment

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DahsboardRepository
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DetailRepository
import org.mongodb.kbson.ObjectId

object Mocks {
    val dashBoardRepository: DetailRepository = object : DetailRepository {
        override suspend fun getDetailContent(objectId: ObjectId): Pair<KajianInterface<String, String>?, String?> {
            TODO("Not yet implemented")
        }

    }
    val repository = object : DahsboardRepository {
        override suspend fun getAllContent(): List<Kajian> {
            TODO("Not yet implemented")
        }
    }
}