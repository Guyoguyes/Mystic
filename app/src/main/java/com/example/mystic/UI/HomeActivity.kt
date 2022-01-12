package com.example.mystic.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystic.Adapters.CountryAdapter
import com.example.mystic.Interface.CountryRetrofit
import com.example.mystic.Model.Country
import com.example.mystic.Model.Response
import com.example.mystic.R
import com.example.mystic.databinding.ActivityHomeBinding
import retrofit2.HttpException
import java.io.IOException
import java.util.ArrayList

class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivity::class.qualifiedName
    private lateinit var countryAdapter: CountryAdapter
    lateinit var countries: ArrayList<Response>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val rvCountry = findViewById<View>(R.id.countryRecyclerId) as RecyclerView
        val adapter = countryAdapter
    }


}