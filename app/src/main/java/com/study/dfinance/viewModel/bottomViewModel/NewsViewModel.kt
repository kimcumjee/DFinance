package com.study.dfinance.viewModel.bottomViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.dfinance.widget.SingleLiveEvent

class NewsViewModel : ViewModel() {
    val image = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    val onClickEvent = SingleLiveEvent<Unit>()

    fun addEvent() = onClickEvent.call()
}