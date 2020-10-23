package com.example.intento7.model.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        val image = itemView.imageView1
        val name = itemView.textView1
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
        Glide.with(holder.itemView.context).load(superHeroes.imageLg).apply(RequestOptions.circleCropTransform()).into(holder.image)
        holder.name.text= superHeroes.name
    }

    override fun getItemCount()= superHeroesList.size
    }
interface PassTheData {
    fun passTheSuperHeroes(superHeroes: SuperHeroesEntity)
}