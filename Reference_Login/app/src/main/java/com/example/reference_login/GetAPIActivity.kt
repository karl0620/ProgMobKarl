package com.example.reference_login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reference_login.Adapter.UserAdapter
import com.example.reference_login.Models.ResponseUserItem
import com.example.reference_login.Network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetAPIActivity: AppCompatActivity() {
    lateinit var rvUser: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_apiactivity)
        rvUser = findViewById(R.id.rvUser)
        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResponseUserItem>> {
                override fun onFailure(
                    call: Call<List<ResponseUserItem>>, t:
                    Throwable
                ) {
                    Toast.makeText(
                        this@GetAPIActivity, t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onResponse(
                    call: Call<List<ResponseUserItem>>,
                    response: Response<List<ResponseUserItem>>
                ) {
                    rvUser.apply {
                        layoutManager = LinearLayoutManager(this@GetAPIActivity)
                        adapter = UserAdapter(response.body())
                    }
                }
            })
    }
}