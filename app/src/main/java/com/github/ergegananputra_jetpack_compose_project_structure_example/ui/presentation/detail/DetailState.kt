package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.detail

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface

data class DetailState(
    val isLoading : Boolean = false,
    val errorMessage : String? = null,

    override var id: String= "",
    override var slug: String?= null,
    override var idUser: String?= null,
    override var idFileKajian: String?= null,
    override var pemateri: String?= null,
    override var judulKajian: String?= null,
    override var fileKajian: String?= null,
    override var deskripsiKajian: String?= null,
    override var tanggalPostingan: String?= null,
    override var lokasiKajian: String?= null,
    override var keywordKajian: String?= null,
    override var fotoKajian: String?= null,
    override var createdAt: String= "",
    override var updatedAt: String= "",
    ) : KajianInterface<String, String>