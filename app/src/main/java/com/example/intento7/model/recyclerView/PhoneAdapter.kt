package com.example.intento7.model.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intento7.R
import com.example.intento7.model.repository.localWithRoom.PhonesEntity
import kotlinx.android.synthetic.main.phones_item_list.view.*

class PhoneAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<PhoneAdapter.PhonesViewHolder>() {

    private var PhonesList = emptyList<PhonesEntity>()

    fun updateAdapter(mList: List<PhonesEntity>){
        PhonesList= mList
        notifyDataSetChanged()
    }

    inner class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mid = itemView.TextViewNameF1
        //        val image = itemView.imageView1
//        val name = itemView.autor


        val clickListener = itemView.setOnClickListener{
        mPassTheData.passThePhone((PhonesList[adapterPosition]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.phones_item_list,parent,false)
        return PhonesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesViewHolder, position: Int) {
        val myPhones= PhonesList[position]
        holder.mid.text= myPhones.Name
//        Glide.with(holder.itemView.context).load(superHeroes.lg).apply(RequestOptions.circleCropTransform()).into(holder.image)
//        holder.name.text= superHeroes.name
    }

    override fun getItemCount()= PhonesList.size
    }
interface PassTheData {
    fun passThePhone(phones: PhonesEntity)
}