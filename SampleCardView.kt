package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.PetaniAdapter
import com.example.myapplication.Adapter.PetaniCVAdapter
import com.example.myapplication.Model.Petani

class SampleCardView : AppCompatActivity() {
    lateinit var rvCardView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)

        rvCardView = findViewById(R.id.rvLatihan)

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
        val petaniAdapterCV = PetaniCVAdapter(listPetani)


        rvCardView.apply {
            layoutManager = LinearLayoutManager(this@SampleCardView)
            adapter = petaniAdapterCV
        }
    }
}