package com.example.databindingfragment.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.databindingfragment.model.DataProvider
import com.example.databindingfragment.model.Product

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var product = DataProvider.productList.get(5)

    fun getProduct(): Product = product

}
