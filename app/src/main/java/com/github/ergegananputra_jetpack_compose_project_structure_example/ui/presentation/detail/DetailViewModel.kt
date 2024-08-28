package com.github.ergegananputra_jetpack_compose_project_structure_example.ui.presentation.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.mongodb.kbson.ObjectId
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel(){
    private val _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    fun getDetail(id: String){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            val objectId = ObjectId(id)
            val pairs = withContext(Dispatchers.IO){
                repository.getDetailContent(objectId)
            }
            val result = pairs.first
            val errorMessage = pairs.second

            if (errorMessage != null){
                Log.d("DetailViewModel", errorMessage)
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = errorMessage
                )
                return@launch
            }

            if (result == null){
                Log.d("DetailViewModel", "Data not found")
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = "Data not found"
                )
                return@launch
            }

            _state.update {
                it.copy(
                    isLoading = false,
                    id = result?.id ?: "",
                    slug = result?.slug,
                    idUser = result?.idUser,
                    idFileKajian = result?.idFileKajian,
                    pemateri = result?.pemateri,
                    judulKajian = result?.judulKajian,
                    fileKajian = result?.fileKajian,
                    deskripsiKajian = result?.deskripsiKajian,
                    tanggalPostingan = result?.tanggalPostingan,
                    lokasiKajian = result?.lokasiKajian,
                    keywordKajian = result?.keywordKajian,
                    fotoKajian = result?.fotoKajian,
                    createdAt = result?.createdAt ?: "",
                    updatedAt = result?.updatedAt ?: ""
                )
            }
        }

    }
}