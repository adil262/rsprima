package com.kelompok3.rsprima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kelompok3.rsprima.databinding.ActivityDetailPerlengkapanBinding

class DetailPerlengkapan : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPerlengkapanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPerlengkapanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(intent.hasExtra("namanya")) {
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val foto: String = this.intent.getStringExtra("fotonya").toString()
            val deskripsi: String = this.intent.getStringExtra("deskripsinya").toString()
            val jumlah: String = this.intent.getStringExtra("jumlahnya").toString()
            val keterangan: String = this.intent.getStringExtra("keterangannya").toString()
            setDetail(foto, nama, deskripsi, jumlah, keterangan)
        }
    }
    fun setDetail(foto: String, nama:String, deskrpsi:String, jumlah:String, keterangan:String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        binding.namaPerlengkapan.text = nama
        binding.deskripsiPerlengkapan.text = deskrpsi
        binding.jumlahPerlengkapan.text = jumlah
        binding.keteranganPerlengkapan.text = keterangan
        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(binding.gambarPerlengkapan)
    }
}