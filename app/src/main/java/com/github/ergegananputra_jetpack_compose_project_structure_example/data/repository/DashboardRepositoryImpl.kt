package com.github.ergegananputra_jetpack_compose_project_structure_example.data.repository

import android.util.Log
import com.github.ergegananputra_jetpack_compose_project_structure_example.data.remote.WebContentCollaborationApiService
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DahsboardRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import org.mongodb.kbson.ObjectId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val webCCApiService: WebContentCollaborationApiService,
    private val realm: Realm
) : DahsboardRepository {

    override suspend fun getAllContent() : List<Kajian> {
        val response = webCCApiService
            .getAllContent()
            .execute()

        if(response.isSuccessful.not()) {
            Log.e("DashboardRepositoryImpl", "Response is not successful")
            return emptyList()
        }

        val responseBody = response.body()?.data ?: run {
            Log.e("DashboardRepositoryImpl", "Response body is null")
            return emptyList()
        }

        val data = responseBody.data

        val convertedData = data.map {
            // response date "2024-06-24T17:54:40.000000Z"

            val createdAt = ZonedDateTime.parse(it.createdAt, DateTimeFormatter.ISO_DATE_TIME)
            val updatedAt = ZonedDateTime.parse(it.updatedAt, DateTimeFormatter.ISO_DATE_TIME)

            val objectId = ObjectId(timestamp = createdAt.toInstant().toEpochMilli())
            Kajian().new(
                id =objectId,
                slug = it.slug,
                idUser = it.idUser,
                idFileKajian = it.idFileKajian,
                pemateri = it.pemateri,
                judulKajian = it.judulKajian,
                fileKajian = it.fileKajian,
                deskripsiKajian = it.deskripsiKajian,
                tanggalPostingan = it.tanggalPostingan,
                lokasiKajian = it.lokasiKajian,
                keywordKajian = it.keywordKajian,
                fotoKajian = it.fotoKajian,
                createdAt = createdAt.toInstant().toEpochMilli(),
                updatedAt = updatedAt.toInstant().toEpochMilli()
            )
        }
        // Save to Local Database
        realm.write {
            convertedData.forEach {
                copyToRealm(it, UpdatePolicy.ALL)
            }
        }

        return convertedData
    }
}