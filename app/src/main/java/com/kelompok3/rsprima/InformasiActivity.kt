package com.kelompok3.rsprima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok3.rsprima.databinding.ActivityInformasiBinding
import com.kelompok3.rsprima.fragments.list.PerlengkapanAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok3.rsprima.data.DataPerlengkapan
import com.kelompok3.rsprima.fragments.list.DekorasiSpasiGambar

class InformasiActivity : AppCompatActivity() {
    private lateinit var perlengkapanAdapter: PerlengkapanAdapter
    private lateinit var binding: ActivityInformasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        tambahDataset()
    }

    private fun tambahDataset(){
        val data = DataPerlengkapan.buatSetData()
        perlengkapanAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager( this@InformasiActivity)
            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            perlengkapanAdapter = PerlengkapanAdapter()
            adapter = perlengkapanAdapter
        }
    }
}