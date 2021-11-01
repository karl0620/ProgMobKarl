package com.example.reference_login.CRUD

import android.content.Intent
import android.content.SharedPreferences
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reference_login.Adapter.UserAdapter
import com.example.reference_login.GetAPIActivity
import com.example.reference_login.Models.ResponseUserItem
import com.example.reference_login.Network.NetworkConfig
import com.example.reference_login.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserActivity : AppCompatActivity(){
    lateinit var rvUser : RecyclerView

    var prefs_name = "session_login"
    lateinit var sharedPref : SharedPreferences

    override fun onRestart() {
        super.onRestart()

        rvUser = findViewById(R.id.rvUser)

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResponseUserItem>> {
                override fun onFailure(
                    call: Call<List<ResponseUserItem>>, t:
                    Throwable
                ) {
                    Toast.makeText(
                        this@GetUserActivity, t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onResponse(
                    call: Call<List<ResponseUserItem>>,
                    response: Response<List<ResponseUserItem>>
                ) {
                    rvUser.apply {
                        layoutManager = LinearLayoutManager(this@GetUserActivity)
                        adapter = UserAdapter(response.body())
                    }
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btnLogout -> {
                val editor : SharedPreferences.Editor = sharedPref.edit()
                editor.clear()
                editor.apply()
                finish()
                var intent = Intent(this@GetUserActivity, GetAPIActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}