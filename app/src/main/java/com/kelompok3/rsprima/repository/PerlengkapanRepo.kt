package com.kelompok3.rsprima.repository

import androidx.lifecycle.LiveData
import com.kelompok3.rsprima.data.PerlengkapanDao
import com.kelompok3.rsprima.model.Perlengkapan

class PerlengkapanRepo(private val perlengkapanDao: PerlengkapanDao) {
    val bacaSemuaData: LiveData<List<Perlengkapan>> = perlengkapanDao.bacaSemuaData()

    suspend fun tambahPerlengkapan(perlengkapan: Perlengkapan){
        perlengkapanDao.tambahPerlengkapan(perlengkapan)
    }

    suspend fun updatePerlengkapan(perlengkapan: Perlengkapan){
        perlengkapanDao.updatePerlengkapan(perlengkapan)
    }

    suspend fun hapusPerlengkapan(perlengkapan: Perlengkapan){
        perlengkapanDao.hapusPerlengkapan(perlengkapan)
    }

    suspend fun hapusSemuaPerlengkapan(){
        perlengkapanDao.hapusSemua()
    }
}