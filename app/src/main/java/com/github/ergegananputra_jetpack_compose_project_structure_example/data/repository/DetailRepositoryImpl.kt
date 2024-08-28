package com.github.ergegananputra_jetpack_compose_project_structure_example.data.repository

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.constants.HOST
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DetailRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import org.mongodb.kbson.ObjectId
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val realm: Realm
) : DetailRepository {
    override suspend fun getDetailContent(objectId: ObjectId): Pair<KajianInterface<String, String>?, String?> {
        val result = object : KajianInterface<String, String> {
            override var id: String = ""
            override var slug: String? =""
            override var idUser: String?  = ""
            override var idFileKajian: String? = ""
            override var pemateri: String? = ""
            override var judulKajian: String? = ""
            override var fileKajian: String? = ""
            override var deskripsiKajian: String? = ""
            override var tanggalPostingan: String? = ""
            override var lokasiKajian: String? = ""
            override var keywordKajian: String? = ""
            override var fotoKajian: String? = ""
            override var createdAt: String = ""
            override var updatedAt: String = ""

        }
        try {
            val kajian = realm
                .query<Kajian>(
                    query = "id == $0",
                    objectId
                )
                .find()
                .first()

            val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

            val createAt = Date(kajian.createdAt)
            val updatedAt = Date(kajian.updatedAt)

            result.apply {
                id = kajian.id.toString()
                slug = kajian.slug
                idUser= kajian.idUser
                idFileKajian= kajian.idFileKajian
                pemateri= kajian.pemateri
                judulKajian= kajian.judulKajian
                fileKajian= "${HOST}storage/${kajian.fileKajian}"
                deskripsiKajian= kajian.deskripsiKajian
                tanggalPostingan= kajian.tanggalPostingan
                lokasiKajian= kajian.lokasiKajian
                keywordKajian= kajian.keywordKajian
                fotoKajian= "${HOST}storage/${kajian.fotoKajian}"
                this.createdAt= dateFormat.format(createAt)
                this.updatedAt= dateFormat.format(updatedAt)
            }

            return Pair(result, null)
        } catch (e: NoSuchElementException) {
            return Pair(null, "Data not found")
        } catch (e: Exception) {
            return Pair(null, e.message)
        }



    }
}