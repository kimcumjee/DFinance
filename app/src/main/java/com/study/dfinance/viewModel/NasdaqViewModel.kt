package com.study.dfinance.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NasdaqViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is nasdaq Fragment"
    }
    val text: LiveData<String> = _text
}