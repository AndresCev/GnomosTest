package com.example.brastlewark.domain

import com.example.brastlewark.data.model.DataSource
import com.example.brastlewark.data.model.Gnome
import com.example.brastlewark.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
   suspend override fun  getGnomeList(): Resource<List<Gnome>> {
       return dataSource.getGnomeByName()
    }

}