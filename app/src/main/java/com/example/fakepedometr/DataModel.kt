package com.example.fakepedometr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel:ViewModel() {

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}