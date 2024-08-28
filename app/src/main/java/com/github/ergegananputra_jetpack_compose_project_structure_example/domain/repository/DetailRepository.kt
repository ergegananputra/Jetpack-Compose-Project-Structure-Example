package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface
import org.mongodb.kbson.ObjectId

interface DetailRepository {
    suspend fun getDetailContent(objectId : ObjectId) : Pair<KajianInterface<String, String>?, String?>
}