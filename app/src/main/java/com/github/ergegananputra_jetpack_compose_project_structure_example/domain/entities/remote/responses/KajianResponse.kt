package com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.remote.responses

import com.google.gson.annotations.SerializedName
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.KajianInterface

data class KajianResponse(
    @SerializedName("id") override var id: Int = 0,
    @SerializedName("slug") override var slug: String? = "",
    @SerializedName("id_user") override var idUser: String? = "",
    @SerializedName("id_file_kajian") override var idFileKajian: String? = "",
    @SerializedName("pemateri") override var pemateri: String? = "",
    @SerializedName("judul_kajian") override var judulKajian: String? = "",
    @SerializedName("file_kajian") override var fileKajian: String? = "",
    @SerializedName("deskripsi_kajian") override var deskripsiKajian: String? = "",
    @SerializedName("tanggal_postingan") override var tanggalPostingan: String? = "",
    @SerializedName("lokasi_kajian") override var lokasiKajian: String? = "",
    @SerializedName("keyword_kajian") override var keywordKajian: String? = "",
    @SerializedName("foto_kajian") override var fotoKajian: String? = "",
    @SerializedName("created_at") override var createdAt: String = "",
    @SerializedName("updated_at") override var updatedAt: String = ""
) : KajianInterface<Int, String>
