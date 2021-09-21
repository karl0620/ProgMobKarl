package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.PetaniAdapter
import com.example.myapplication.Model.Petani

class SampleRecyclerView : AppCompatActivity() {
        lateinit var rvLat : RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sample_recycler_view)

            rvLat = findViewById(R.id.rvLatihan)

            var listPetani = listOf(
                Petani(
                    user = "UU01", nama = "HENRIKUS", jumlahLahan = "10",
                    identifikasi = "20",
                    tambahLahan = "10"),
                Petani(
                    user = "UU02", nama = "KAREL", jumlahLahan = "20",
                    identifikasi = "30",
                    tambahLahan = "5"),
                Petani(
                    user = "UU03", nama = "DWIPUTRA", jumlahLahan = "20",
                    identifikasi = "30",
                    tambahLahan = "15"),
                Petani(
                    user = "UU04", nama = "KARL", jumlahLahan = "20",
                    identifikasi = "30",
                    tambahLahan = "20"),
                Petani(
                    user = "UU05", nama = "RIKUU", jumlahLahan = "20",
                    identifikasi = "30",
                    tambahLahan = "10"),
            )
            val petaniAdapter = PetaniAdapter(listPetani)

            rvLat.apply {
                layoutManager = LinearLayoutManager(this@SampleRecyclerView)
                adapter = petaniAdapter
            }

        }
}