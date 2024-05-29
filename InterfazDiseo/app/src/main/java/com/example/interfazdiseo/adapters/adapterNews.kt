package com.example.interfazdiseo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interfazdiseo.R
import com.example.interfazdiseo.models.news

class adapterNews
    (var listaNoticias: List<news>,
    var context: Context
    ):RecyclerView.Adapter<adapterNews.MyHolder>()
    {
        /*
        se crea la clase MyHolder
         */
        inner class  MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            /*
            Dentro de la clase de MyHolder se crea las varibales y se asocian los objetos de la vista item
             */
            val lblName: TextView = itemView.findViewById(R.id.lblName)
            val lblDescripticion: TextView = itemView.findViewById(R.id.lblDescripcion)
            val imagen: ImageView = itemView.findViewById(R.id.imagen)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterNews.MyHolder {
            var itemView= LayoutInflater.from(context).inflate(R.layout.items_news,parent,false)
            return MyHolder(itemView)
        }

        override fun onBindViewHolder(holder: adapterNews.MyHolder, position: Int) {
            //Obtener el registro
            val news=listaNoticias[position]
            //asignar valores
            holder.lblName.text=news.name
            holder.lblDescripticion.text=news.description
            holder.imagen.setImageResource(news.photo)
        }
        /*
        getItemCount: retorna el numero de elementos de la lista
         */

        override fun getItemCount(): Int {
            return listaNoticias.size
        }
}

private fun ImageView.setImageResource(photo: String) {

}



