package com.example.brastlewark.data.model
import com.example.brastlewark.vo.Resource
import com.example.brastlewark.vo.RetrofitClient


class DataSource {

    suspend fun getGnomeByName(): Resource<List<Gnome>>{
        return Resource.Success(RetrofitClient.webService.getGnomeByName().gnomeList)

    }




}


