package com.example.androidui.main.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.main.bean.AddPhotoBean

class AddPhotosAdapter (private var dataList: List<AddPhotoBean>) : RecyclerView.Adapter<AddPhotosAdapter.ViewHolder>() {



    public interface  OnItemClickListener{
        fun onClick(state : String)
    }

    lateinit var listener : OnItemClickListener

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.add_photos_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (dataList.isEmpty()){
            holder.imgFiv!!.setImageResource(R.mipmap.ic_add_image)
        }else{
            //holder.imgFiv!!.setImageURI(dataList.get(position).uri)
        }

        holder.itemView.setOnClickListener{
            listener.onClick(position.toString())
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return dataList.size+1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgFiv : ImageView? = null
        init {
            imgFiv =  itemView.findViewById(R.id.img_fiv)
        }
    }

}