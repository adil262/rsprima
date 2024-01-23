package com.kelompok3.rsprima.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.kelompok3.rsprima.model.Perlengkapan

@Dao
interface PerlengkapanDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tambahPerlengkapan(perlengkapan: Perlengkapan)

    @Query("SELECT * FROM perlengkapan_rs ORDER BY id ASC")
    fun bacaSemuaData(): LiveData<List<Perlengkapan>>

    @Update
    suspend fun updatePerlengkapan(perlengkapan: Perlengkapan)

    @Delete
    suspend fun hapusPerlengkapan(perlengkapan: Perlengkapan)

    @Query("DELETE FROM perlengkapan_rs")
    suspend fun hapusSemua()
}