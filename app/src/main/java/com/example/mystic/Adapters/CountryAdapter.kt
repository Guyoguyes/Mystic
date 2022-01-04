package com.example.mystic.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mystic.Model.Country
import com.example.mystic.databinding.CountryBinding
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

class CountryAdapter(val context: Context): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    class ViewHolder(val binding: CountryBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var countries: List<Country>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val country = countries[position]
            countryName.text = country.name
            Picasso.with(context).load(country.flag).into(countryFlag)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}