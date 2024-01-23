package com.kelompok3.rsprima.fragments.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kelompok3.rsprima.DetailPerlengkapan
import com.kelompok3.rsprima.R
import com.kelompok3.rsprima.databinding.LayoutListPerlengkapanBinding
import com.kelompok3.rsprima.model.ListObjPerlengkapan

class PerlengkapanAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<ListObjPerlengkapan> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosenViewHolder {
        val binding = LayoutListPerlengkapanBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return DosenViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is DosenViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener{
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }
    fun submitList(listDosen: List<ListObjPerlengkapan>) {
        items = listDosen
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class DosenViewHolder constructor(val binding: LayoutListPerlengkapanBinding):
        RecyclerView.ViewHolder(binding.root){
        val foto_pl: ImageView = binding.gambarPerlengkapan
        val nama_pl: TextView = binding.namaPerlengkapan
        val klik: RelativeLayout = binding.rlKlik

        fun bind(listObjPerlengkapan: ListObjPerlengkapan){
            nama_pl.setText(listObjPerlengkapan.nama)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjPerlengkapan.gambar)
                .into(foto_pl)
        }
        fun kalau_diklik(get: ListObjPerlengkapan){
            Toast.makeText(itemView.context, "Kamu memilih: ${get.nama}", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, DetailPerlengkapan::class.java)
            intent.putExtra("namanya", get.nama)
            intent.putExtra("deskripsinya", get.deskripsi)
            intent.putExtra("fotonya", get.gambar)
            intent.putExtra("jumlahnya", get.jumlah)
            intent.putExtra("keterangannya", get.keterangan)
            itemView.context.startActivity(intent)
        }
    }
}