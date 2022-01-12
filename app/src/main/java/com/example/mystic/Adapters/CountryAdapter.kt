package com.example.mystic.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mystic.Model.Response
import com.example.mystic.R
import kotlinx.android.synthetic.main.country_list.view.*

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }


    private val diffCallback = object : DiffUtil.ItemCallback<Response>(){
        override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       return CountryViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.country_list, parent, false
           )
       )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(country.flag).into(countryFlag)
            countryName.text = country.name
            totalLeague.text = country.code
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}