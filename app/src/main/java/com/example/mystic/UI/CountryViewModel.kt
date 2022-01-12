package com.example.mystic.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystic.Model.CountryDebug
import com.example.mystic.util.Resource
import kotlinx.coroutines.launch

class CountryViewModel: ViewModel() {
    val availableCountries: MutableLiveData<Resource<CountryDebug>> = MutableLiveData()

    fun getAllCountries() = viewModelScope.launch {
        availableCountries.postValue(Resource.Loading())
    }
}