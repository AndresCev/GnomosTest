package com.example.brastlewark.domain

import com.example.brastlewark.data.model.Gnome
import com.example.brastlewark.vo.Resource

interface Repo {
   suspend fun getGnomeList():Resource<List<Gnome>>

}