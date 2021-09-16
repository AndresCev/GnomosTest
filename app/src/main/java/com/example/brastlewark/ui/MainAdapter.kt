package com.example.brastlewark.ui

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.brastlewark.R
import com.example.brastlewark.base.BaseViewHolder
import com.example.brastlewark.data.model.Gnome
import kotlinx.android.synthetic.main.gnome_row.view.*

class MainAdapter(private val context: Context, private val gnomesList:List<Gnome>, private val itemClickLister:OnGnomeClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnGnomeClickListener{
        fun onGnomeClick(gnome: Gnome)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.gnome_row,parent,false))
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(gnomesList[position],position)
        }
    }

    override fun getItemCount(): Int {
        return gnomesList.size
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Gnome>(itemView){
        override fun bind(item: Gnome, position: Int){
            print(item.hairColor)
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_gnome)
            //Picasso.get().load(item.imagen).into(itemView.img_trago)
            var Age = "Age: ${item.age}"
            itemView.tv_Title.text = item.name
            itemView.tv_Description.text = Age
            itemView.setOnClickListener{itemClickLister.onGnomeClick(item)}

            Log.d("DETALLES", "${item.hairColor}")


            when(item.hairColor){
                "Green" ->  {itemView.setBackgroundColor(Color.argb(255, 73, 160, 33))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(itemView.img_gnome)
                }
                "Pink" ->   {itemView.setBackgroundColor(Color.argb(255, 193, 10, 147))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(itemView.img_gnome)


                }
                "Red" ->    {itemView.setBackgroundColor(Color.argb(255, 170, 12, 12))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-gnomo-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248932.jpg").into(itemView.img_gnome)
                }
                "Gray" -> {
                    itemView.setBackgroundColor(Color.argb(255, 117, 117, 117))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(itemView.img_gnome)
                }

                "Black" ->  {itemView.setBackgroundColor(Color.argb(255, 255, 255, 255))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-gnomo-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248932.jpg").into(itemView.img_gnome)
                }

                else ->     {itemView.setBackgroundColor(Color.argb(255, 255, 255, 255))
                    Glide.with(context).load("https://thumbs.dreamstime.com/b/icono-del-duende-de-la-mujer-estilo-plano-ejemplo-vector-para-el-dise%C3%B1o-web-142248877.jpg").into(itemView.img_gnome)

                }

            }





        }
    }

}