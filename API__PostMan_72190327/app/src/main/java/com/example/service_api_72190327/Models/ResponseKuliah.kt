package com.example.service_api_72190327.Models

import com.google.gson.annotations.SerializedName

data class ResponseKuliah(

	@field:SerializedName("ResponseKuliah")
	val responseKuliah: List<ResponseKuliahItem?>? = null
)

data class ResponseKuliahItem(

	@field:SerializedName("hari")
	val hari: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("kode")
	val kode: String? = null,

	@field:SerializedName("sks")
	val sks: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("sesi")
	val sesi: String? = null
)
