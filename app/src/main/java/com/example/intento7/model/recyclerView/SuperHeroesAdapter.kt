package com.example.intento7.model.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intento7.R
import com.example.intento7.model.repository.localWithRoom.SuperHeroesEntity
import kotlinx.android.synthetic.main.super_heroes_item_list.view.*

class SuperHeroesAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<SuperHeroesAdapter.SuperHeroesViewHolder>() {

    private var superHeroesList = emptyList<SuperHeroesEntity>()

    fun updateAdapter(mList: List<SuperHeroesEntity>){
        superHeroesList= mList
        notifyDataSetChanged()
    }

    inner class SuperHeroesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id = itemView.
//        val image = itemView.imageView1
//        val name = itemView.autor
//        val autor = itemView.TextViewNameF1
//        val fecha = itemView.fecha
//        val version = itemView.version
//        val bitcoinNombre = itemView.bitcoinNombre
//        val dolarNombre = itemView.dolarNombre
//        val dolarIntercambioNombreme = itemView.dolarIntercambioNombre
//        val euroNombre = itemView.euroNombre
//        val imacecNombre = itemView.imacecNombre
//        val ipcNombre = itemView.ipcNombre
//        val ivpNombre = itemView.textViewivpNombre
//        val libraCobreNombre = itemView.textViewlibraCobreNombre
//        val tasaDesempleoNombre = itemView.textViewtasaDesempleoNombre
//        val tpmNombre = itemView.textViewtpmNombre
//        val ufNombre = itemView.textViewufNombre
//        val utmNombre = itemView.textViewutmNombre

        val clickListener = itemView.setOnClickListener{
        mPassTheData.passTheSuperHeroes((superHeroesList[adapterPosition]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroesViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.super_heroes_item_list,parent,false)
        return SuperHeroesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroesViewHolder, position: Int) {
        val superHeroes= superHeroesList[position]
        holder.id.text
//        Glide.with(holder.itemView.context).load(superHeroes.lg).apply(RequestOptions.circleCropTransform()).into(holder.image)
//        holder.name.text= superHeroes.name
//        holder.autor.text= superHeroes.autor
//        holder.fecha.text= superHeroes.fecha
//        holder.version.text= superHeroes.version
//        holder.bitcoinNombre.text= superHeroes.bitcoinNombre
//        holder.dolarNombre.text= superHeroes.dolarNombre
//        holder.dolarIntercambioNombreme.text= superHeroes.dolarIntercambioNombre
//        holder.euroNombre.text= superHeroes.euroNombre
//        holder.imacecNombre.text= superHeroes.imacecNombre
//        holder.ipcNombre.text= superHeroes.ipcNombre
//        holder.ivpNombre.text= superHeroes.ivpNombre
//        holder.libraCobreNombre.text= superHeroes.libraCobreNombre
//        holder.tasaDesempleoNombre.text= superHeroes.tasaDesempleoNombre
//        holder.tpmNombre.text= superHeroes.tpmNombre
//        holder.ufNombre.text= superHeroes.ufNombre
//        holder.utmNombre.text= superHeroes.utmNombre
    }

    override fun getItemCount()= superHeroesList.size
    }
interface PassTheData {
    fun passTheSuperHeroes(superHeroes: SuperHeroesEntity)
}