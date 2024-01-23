package com.kelompok3.rsprima.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kelompok3.rsprima.R
import com.kelompok3.rsprima.model.Perlengkapan
import com.kelompok3.rsprima.viewmodel.PerlengkapanViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mPerlengkapanViewModel: PerlengkapanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mPerlengkapanViewModel = ViewModelProvider(this).get(PerlengkapanViewModel::class.java)
        view.edt_update_nama.setText(args.curPerlengkapan.nama)
        view.edt_update_deskrpsi.setText(args.curPerlengkapan.deskripsi)
        view.edt_update_jumlah.setText(args.curPerlengkapan.jumlah)
        view.edt_update_keterangan.setText(args.curPerlengkapan.keterangan)

        view.btn_update.setOnClickListener{
            updateItem()
        }
        setHasOptionsMenu(true)
        return view
    }

    private fun updateItem(){
        val nama = edt_update_nama.text.toString()
        val deskripsi = edt_update_deskrpsi.text.toString()
        val jumlah = edt_update_jumlah.text.toString()
        val keterangan = edt_update_keterangan.text.toString()

        if(cekInput(nama, deskripsi, jumlah, keterangan)){
            val updatedData = Perlengkapan(args.curPerlengkapan.id, nama, deskripsi, jumlah, keterangan)
            mPerlengkapanViewModel.updatePerlengkapan(updatedData)

            Toast.makeText(requireContext(), "Data berhasil di Update", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun cekInput(
        nama:String,
        deskripsi: String,
        jumlah: String,
        keterangan: String
    ): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(deskripsi) && TextUtils.isEmpty(jumlah) && TextUtils.isEmpty(keterangan))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hapus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_hapus){
            hapusPerlengkapan()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hapusPerlengkapan(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Iya"){ _, _ ->
            mPerlengkapanViewModel.hapusPerlengkapan(args.curPerlengkapan)
            Toast.makeText(
                requireContext(),
                "Perlengkapan ${args.curPerlengkapan.nama} berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("Tidak"){_, _ -> }
        builder.setTitle("Hapus ${args.curPerlengkapan.nama} ?")
        builder.setMessage("Apakah kamu yakin ingin menghapus data ini?")
        builder.create().show()
    }

}