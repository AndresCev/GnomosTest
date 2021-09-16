 package com.example.brastlewark.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.brastlewark.R
import com.example.brastlewark.data.model.Gnome
import kotlinx.android.synthetic.main.fragment_gnomes_detalles.*


 class GnomesDetallesFragment : Fragment() {
    private lateinit var gnome: Gnome


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            gnome = it.getParcelable("gnome")!!
            Log.d("DETALLES", "$gnome")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gnomes_detalles, container, false)
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         var weight = "Weight: ${gnome.weight}"
         var height = "Height: ${gnome.height}"
         var professions = "Professions: ${gnome.professions}"
         var friends = "Friends: ${gnome.friends}"

         //Cargar las imagenes produce error 503 por lo que es un fallo en el servidor
        // Glide.with(requireContext()).load(drink.imagen).into(img_Detalles)
         tv_titulo.text = gnome.name
         tv_professions.text = professions
         tv_friends.text = friends

         tv_weight.text = weight
         tv_height.text = height
         when(gnome.hairColor){
             "Green" ->  {view.setBackgroundColor(Color.argb(255, 73, 160, 33))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(img_Detalles)
             }
             "Pink" ->   {view.setBackgroundColor(Color.argb(255, 193, 10, 147))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(img_Detalles)


             }
             "Red" ->    {view.setBackgroundColor(Color.argb(255, 170, 12, 12))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-gnomo-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248932.jpg").into(img_Detalles)
             }
             "Gray" -> {
                 view.setBackgroundColor(Color.argb(255, 117, 117, 117))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(img_Detalles)
             }

             "Black" ->  {view.setBackgroundColor(Color.argb(255, 255, 255, 255))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-gnomo-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248932.jpg").into(img_Detalles)
             }

             else ->     {view.setBackgroundColor(Color.argb(255, 255, 255, 255))
                 Glide.with(requireContext()).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(img_Detalles)

             }

         }
     }


}