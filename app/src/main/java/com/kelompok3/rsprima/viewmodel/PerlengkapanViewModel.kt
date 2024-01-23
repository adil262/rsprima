package com.kelompok3.rsprima.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kelompok3.rsprima.model.Perlengkapan
import com.kelompok3.rsprima.data.PerlengkapanDb
import com.kelompok3.rsprima.repository.PerlengkapanRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerlengkapanViewModel(application: Application): AndroidViewModel(application) {
    val bacaSemuaData: LiveData<List<Perlengkapan>>
    private val repo: PerlengkapanRepo

    init {
        val perlengkapanDAO = PerlengkapanDb.getDb(application).perlengkapanDao()
        repo = PerlengkapanRepo(perlengkapanDAO)
        bacaSemuaData = repo.bacaSemuaData
    }

    fun tambahPerlengkapan(perlengkapan: Perlengkapan){
        viewModelScope.launch(Dispatchers.IO) {
            repo.tambahPerlengkapan(perlengkapan)
        }
    }
    fun updatePerlengkapan(perlengkapan: Perlengkapan){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updatePerlengkapan(perlengkapan)
        }
    }
    fun hapusPerlengkapan(perlengkapan: Perlengkapan){
        viewModelScope.launch(Dispatchers.IO) {
            repo.hapusPerlengkapan(perlengkapan)
        }
    }
    fun hapusSemuaPerlengkapan(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.hapusSemuaPerlengkapan()
        }
    }
}