package com.example.service_api_72190327.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.service_api_72190327.Models.DataItem
import com.example.service_api_72190327.R

class PetaniAdapter(val petani: List<DataItem>?) :
    RecyclerView.Adapter<PetaniAdapter.PetaniHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PetaniAdapter.PetaniHolder {
            return PetaniHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_user, parent, false))
        }
        override fun onBindViewHolder(holder: PetaniAdapter.PetaniHolder, position: Int) {
            holder.bindUsers(petani?.get(position))
        }
        override fun getItemCount(): Int {
            return petani?.size ?: 0
        }
        class PetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
            lateinit var txtNama: TextView
            lateinit var txtAlamat: TextView
            lateinit var txtId: TextView
            lateinit var txtNamaIstri: TextView
            lateinit var txtJumlahLahan: TextView
            fun bindUsers(users: DataItem?) {
                itemView.apply {
                    txtNama = findViewById(R.id.nama)
                    txtNamaIstri = findViewById(R.id.nama_istri)
                    txtAlamat = findViewById(R.id.alamat)
                    txtId = findViewById(R.id.id)
                    txtJumlahLahan = findViewById(R.id.jumlah_lahan)

                    txtNama.text = users?.nama
                    txtNamaIstri.text = users?.namaIstri
                    val address = "${users?.alamat}, ${users?.kelurahan}, ${users?.kecamatan}, ${users?.kabupaten}, ${users?.provinsi}"
                    txtAlamat.text = address
                    txtId.text = users?.id
                    txtJumlahLahan.text = users?.jumlahLahan

                }
            }
        }
}

