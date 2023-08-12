package com.example.mvvmdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel()
{
    private val _loginResult =MutableLiveData<Boolean>()
    val loginResult :LiveData<Boolean> get() = _loginResult

    fun performLogin(username:String,password:String){
        val success=username=="admin" && password=="password"
        _loginResult.value=success
    }

    override fun onCleared() {
        super.onCleared()
    }
}