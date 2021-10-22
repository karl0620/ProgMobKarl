package com.example.service_api_72190327.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.service_api_72190327.Models.ResponseKuliahItem
import com.example.service_api_72190327.R

class KuliahAdapter(val matkul: List<ResponseKuliahItem?>) :
    RecyclerView.Adapter<KuliahAdapter.KuliahHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): KuliahAdapter.KuliahHolder {
            return KuliahHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_user, parent, false))
        }
        override fun onBindViewHolder(holder: KuliahAdapter.KuliahHolder, position: Int) {
            holder.bindUsers(matkul?.get(position))
        }
        override fun getItemCount(): Int {
            return matkul?.size ?: 0
        }
        class KuliahHolder(view: View) : RecyclerView.ViewHolder(view) {
            lateinit var txtKode: TextView
            lateinit var txtNama: TextView
            lateinit var txtHari: TextView
            lateinit var txtSesi: TextView
            lateinit var txtSks: TextView
            fun bindUsers(kuliah: ResponseKuliahItem?) {
                itemView.apply {
                    txtNama = findViewById(R.id.nama)
                    txtSesi = findViewById(R.id.sesi)
                    txtHari = findViewById(R.id.hari)
                    txtKode = findViewById(R.id.kode)
                    txtSks = findViewById(R.id.sks)

                    txtKode.text = kuliah?.nama
                    txtSesi.text = kuliah?.sesi
                    txtHari.text = kuliah?.hari
                    txtKode.text = kuliah?.kode
                    txtSks.text = kuliah?.sks
                }
            }
        }
}