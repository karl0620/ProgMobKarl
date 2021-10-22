package com.example.service_api_72190327

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.service_api_72190327.Adapter.KuliahAdapter
import com.example.service_api_72190327.Models.ResponseKuliah
import com.example.service_api_72190327.Models.ResponseKuliahItem
import com.example.service_api_72190327.Network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetAPIActivity : AppCompatActivity() {
    lateinit var rvUser : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_apiactivity)
        rvUser = findViewById(R.id.rvUser)
        NetworkConfig().getService()
            .getKuliahAll()
            .enqueue(object : Callback<ResponseKuliah?>  {
                override fun onFailure(call: Call<ResponseKuliah?>, t: Throwable) {
                    Toast.makeText(this@GetAPIActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<ResponseKuliah?>,
                    response: Response<ResponseKuliah?>
                ) {
                    rvUser.apply{
                        layoutManager = LinearLayoutManager(this@GetAPIActivity)
                        adapter = KuliahAdapter(response.body()?.responseKuliah as List<ResponseKuliahItem?>)
                    }
                }
            })

    }
}

