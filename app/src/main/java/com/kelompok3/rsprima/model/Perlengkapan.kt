package com.kelompok3.rsprima.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "perlengkapan_rs")
data class Perlengkapan(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nama: String,
    val deskripsi: String,
    val jumlah:String,
    val keterangan:String
): Parcelable
