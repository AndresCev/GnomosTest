package com.example.brastlewark.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.brastlewark.domain.Repo
import com.example.brastlewark.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo): ViewModel(){

    val fetchGnomesList = liveData(Dispatchers.IO){

        emit(Resource.Loading())
        try{
            emit(repo.getGnomeList())
        }catch (e: Exception){
            emit(Resource.Failure(e))

        }


    }


}