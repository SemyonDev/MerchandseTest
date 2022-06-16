package com.tapmobile.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapmobile.merchandsetest.entities.Merchandise
import com.tapmobile.merchandsetest.entities.MerchandiseList
import com.tapmobile.myapplication.usecases.GetInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val useCaseInfo: GetInfoUseCase) : ViewModel() {

    private val _merchandiseList = MutableLiveData<MerchandiseList>()
    val merchandiseList: LiveData<MerchandiseList> get() = _merchandiseList

    init {
        getInfo()
    }

    private fun getInfo() {
        viewModelScope.launch(Dispatchers.Default) {
            val merchandiseList = useCaseInfo.getMernchandiseList()
            _merchandiseList.postValue(merchandiseList)
        }
    }
}