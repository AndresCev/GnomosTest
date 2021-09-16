package com.example.brastlewark.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Gnome(
    @SerializedName("thumbnail")
    var imagen: String,

    @SerializedName("name")
val name:String = "",

    @SerializedName("hair_color")
val hairColor: String = "",

    @SerializedName("age")
    val age: Int,
    @SerializedName("weight")
    val weight: Float,
    @SerializedName("height")
    val height: Float,
    @SerializedName("friends")
    val friends: List<String>,
    @SerializedName("professions")
    val professions: List<String>,






    ):Parcelable

data class GnomeList(
    @SerializedName("Brastlewark")
    val gnomeList:List<Gnome>)

