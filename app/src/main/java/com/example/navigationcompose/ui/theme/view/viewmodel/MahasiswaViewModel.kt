package com.example.navigationcompose.ui.theme.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    private val _mahasiswaStateUI = MutableStateFlow(Mahasiswa())

    val mahasiswaUiState: StateFlow<Mahasiswa> = _mahasiswaStateUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        _mahasiswaStateUI.update { statusSaatini ->
            statusSaatini.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2],
            )
        }
    }
}