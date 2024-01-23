package com.kelompok3.rsprima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kelompok3.rsprima.databinding.ActivityLokasiBinding

class LokasiActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLokasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLokasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val rsprima = LatLng(0.4995055263530185, 101.40071821117645)
        val gudang = LatLng(0.5033073294090223, 101.42470647104975)
        mMap.addMarker(MarkerOptions().position(rsprima).title("RS Prima Pekanbaru"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rsprima))
        mMap.addMarker(MarkerOptions().position(gudang).title("Toko Alat Kesahatan Pekanbaru"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gudang))
    }
}