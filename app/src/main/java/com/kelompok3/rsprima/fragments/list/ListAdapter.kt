package com.kelompok3.rsprima.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.kelompok3.rsprima.R
import androidx.recyclerview.widget.RecyclerView
import com.kelompok3.rsprima.model.Perlengkapan
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var perlengkapanList = emptyList<Perlengkapan>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curItem = perlengkapanList[position]
        holder.itemView.tx_nama.text = curItem.nama
        holder.itemView.tx_deskripsi.text = curItem.deskripsi
        holder.itemView.tx_jumlah.text = curItem.jumlah
        holder.itemView.tx_keterangan.text = curItem.keterangan

        holder.itemView.custom_row.setOnClickListener{
            val aksi = ListFragmentDirections.actionListFragmentToUpdateFragment(curItem)
            holder.itemView.findNavController().navigate(aksi)
        }
    }

    fun tampilkanData(perlengkapan: List<Perlengkapan>){
        this.perlengkapanList = perlengkapan
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return perlengkapanList.size
    }
}