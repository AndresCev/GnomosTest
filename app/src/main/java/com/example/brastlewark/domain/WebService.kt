package com.example.brastlewark.domain


import com.example.brastlewark.data.model.GnomeList
import retrofit2.http.GET

interface WebService {


        @GET("data.json")
       suspend fun getGnomeByName(): GnomeList

}