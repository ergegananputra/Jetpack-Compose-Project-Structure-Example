package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Kajian: RealmObject, KajianInterface<ObjectId, Long> {
    @PrimaryKey
    override var id: ObjectId = ObjectId()
    override var slug: String? = ""
    override var idUser: String? = ""
    override var idFileKajian: String? = ""
    override var pemateri: String? = ""
    override var judulKajian: String? = ""
    override var fileKajian: String? = ""
    override var deskripsiKajian: String? = ""
    override var tanggalPostingan: String? = ""
    override var lokasiKajian: String? = ""
    override var keywordKajian: String? = ""
    override var fotoKajian: String? = ""
    override var createdAt: Long = System.currentTimeMillis()
    override var updatedAt: Long = System.currentTimeMillis()

    fun new(
        id: ObjectId = ObjectId(),
        slug: String?,
        idUser: String?,
        idFileKajian: String?,
        pemateri: String?,
        judulKajian: String?,
        fileKajian: String?,
        deskripsiKajian: String?,
        tanggalPostingan: String?,
        lokasiKajian: String?,
        keywordKajian: String?,
        fotoKajian: String?,
        createdAt: Long = System.currentTimeMillis(),
        updatedAt: Long = System.currentTimeMillis()
    ) : Kajian {
        this.id = id
        this.slug = slug
        this.idUser = idUser
        this.idFileKajian = idFileKajian
        this.pemateri = pemateri
        this.judulKajian = judulKajian
        this.fileKajian = fileKajian
        this.deskripsiKajian = deskripsiKajian
        this.tanggalPostingan = tanggalPostingan
        this.lokasiKajian = lokasiKajian
        this.keywordKajian = keywordKajian
        this.fotoKajian = fotoKajian
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        return this
    }

}