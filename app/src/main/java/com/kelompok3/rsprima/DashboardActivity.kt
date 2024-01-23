package com.kelompok3.rsprima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok3.rsprima.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.maps.setOnClickListener {
            startActivity(Intent(this, LokasiActivity::class.java))
        }
        binding.about.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        binding.rinformasi.setOnClickListener {
            startActivity(Intent(this, InformasiActivity::class.java))
        }
    }
}