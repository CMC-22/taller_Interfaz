package com.example.recyclerviewempleado.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewempleado.R
import com.example.recyclerviewempleado.models.empleado
import java.text.FieldPosition

/*
esta clase es la encargada de cargar los datos del recycleView
Para instanciar la clase se requiere unos parametros
1.Lista elementos
2.Contexto de la aplicacion

Esta clase debe heredar de la clase RecycleView.Adapter
para heredar se utiliza: y la clase de donde se va a heredar
*/
class adapterEmpleado
    (var listEmpleado: List<empleado>,
            var context: Context
            ):RecyclerView.Adapter<adapterEmpleado.MyHolder>()
{
                /*
                se crea la clase MyHolder
                 */
                inner class  MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                    /*
                    Dentro de la clase de MyHolder se crea las varibales y se asocian los objetos de la vista item
                     */
                    lateinit var lblName: TextView
                    lateinit var lblPosition: TextView

                    init {
                        lblName=itemView.findViewById(R.id.lblName)
                        lblPosition=itemView.findViewById(R.id.lblPosition)
                    }
                }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterEmpleado.MyHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.items_empleado,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterEmpleado.MyHolder, position: Int) {
        //Obtener el registro
        val empleado=listEmpleado[position]
        //asignar valores
        holder.lblName.text=empleado.name
        holder.lblPosition.text=empleado.position
    }
    /*
    getItemCount: retorna el numero de elementos de la lista
     */

    override fun getItemCount(): Int {
        return listEmpleado.size
    }
}