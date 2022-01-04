package com.example.mystic.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystic.Adapters.CountryAdapter
import com.example.mystic.Interface.CountryRetrofit
import com.example.mystic.Model.Country
import com.example.mystic.R
import com.example.mystic.databinding.ActivityHomeBinding
import retrofit2.HttpException
import java.io.IOException
import java.util.ArrayList

class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivity::class.qualifiedName

    private lateinit var binding: ActivityHomeBinding
    private lateinit var countryAdapter: CountryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            val response = try{

                Log.d(TAG, CountryRetrofit.api.getCountrys().toString())
                CountryRetrofit.api.getCountrys()
            }catch (e: IOException){
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            }catch (e: HttpException){
                Log.e(TAG, "HttpException, you might not have internet connection")
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null){
                countryAdapter.countries = response.body()!!
            }else{
                Log.e(TAG, "Response not successful")
            }
        }
    }

    private fun setupRecyclerView() = binding.countryRecyclerId.apply{
        countryAdapter = CountryAdapter(this@HomeActivity)
        adapter = countryAdapter
        layoutManager = LinearLayoutManager(this@HomeActivity)
    }
}