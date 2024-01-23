package com.kelompok3.rsprima.fragments.tambah

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kelompok3.rsprima.R
import com.kelompok3.rsprima.model.Perlengkapan
import com.kelompok3.rsprima.viewmodel.PerlengkapanViewModel
import kotlinx.android.synthetic.main.fragment_tambah.*
import kotlinx.android.synthetic.main.fragment_tambah.view.*

class TambahFragment : Fragment() {
    private lateinit var mPerlengkapanViewModel: PerlengkapanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tambah, container, false)

        mPerlengkapanViewModel = ViewModelProvider(this).get(PerlengkapanViewModel::class.java)

        view.btn_add.setOnClickListener{
            masukkanDataKeDatabase()
        }
        return view
    }

    private fun masukkanDataKeDatabase(){
        val nama = edt_nama.text.toString()
        val deskripsi = edt_deskrpsi.text.toString()
        val jumlah = edt_jumlah.text.toString()
        val keterangan = edt_keterangan.text.toString()

        if(cekInput(nama, deskripsi, jumlah, keterangan)){
            val perlengkapan = Perlengkapan(0, nama, deskripsi, jumlah, keterangan)

            mPerlengkapanViewModel.tambahPerlengkapan(perlengkapan)
            Toast.makeText(requireContext(), "Data Berhasil ditambahkan", Toast.LENGTH_SHORT)
                .show()

            findNavController().navigate(R.id.action_tambahFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Silahkan isi dulu datanya", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun cekInput(
        nama: String,
        deskripsi: String,
        jumlah: String,
        keterangan: String
    ): Boolean {
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(deskripsi) && TextUtils.isEmpty(jumlah) && TextUtils.isEmpty(keterangan))
    }
}