package com.example.dam.pokedex

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView

class NewAdapter(private val listPokem: ArrayList<Pokemon>) :

        RecyclerView.Adapter<NewAdapter.pokeViewHolder>() {

    override fun getItemCount(): Int {
        return listPokem.size
    }

    override fun onBindViewHolder(p0: pokeViewHolder, p1: Int) {
        p0.num.text = listPokem[p1].num
        p0.nombre.text = listPokem[p1].nombre
        p0.tipo.text = "Tipo: "+listPokem[p1].tipo
        p0.desc.text = "Datos: "+listPokem[p1].desc

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): pokeViewHolder {
        val v = LayoutInflater.from(p0.getContext()).inflate(R.layout.pokeview, p0, false)
        return pokeViewHolder(v)
    }

    class pokeViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //internal var cv: CardView = itemView.findViewById(R.id.cv)
        internal var num: TextView=itemView.findViewById(R.id.numn)
        internal var tipo: TextView= itemView.findViewById(R.id.tipon)
        internal var desc: TextView= itemView.findViewById(R.id.descn)
        internal var nombre: TextView= itemView.findViewById(R.id.nombren)
        //internal var pokeFoto: ImageView= itemView.findViewById(R.id.pokeFoto) as ImageView
    }

}