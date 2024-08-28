package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities

interface KajianInterface<ID, TIME> {
    var id: ID
    var slug: String?
    var idUser: String?
    var idFileKajian: String?
    var pemateri: String?
    var judulKajian: String?
    var fileKajian: String?
    var deskripsiKajian: String?
    var tanggalPostingan: String?
    var lokasiKajian: String?
    var keywordKajian: String?
    var fotoKajian: String?
    var createdAt: TIME
    var updatedAt: TIME
}
