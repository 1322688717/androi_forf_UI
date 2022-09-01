package com.example.androidui.main.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.MainActivity
import com.example.androidui.R
import java.text.FieldPosition

class StateAdapter(var stateList: MutableList<String>,var activity: Activity,var mPostion: Int) : RecyclerView.Adapter<StateAdapter.ViewHolder>() {



    public interface  OnItemClickListener{
        fun onClick(state : String)
    }

    lateinit var listener : OnItemClickListener
    fun setOnItemClickListener(listener : OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.state_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvState!!.text = stateList[position]
        if (mPostion == position){

            holder. tvState!!.setBackgroundResource(R.drawable.bg_shap_af94e6)
            holder.  tvState!!.setTextColor(activity.resources.getColor(R.color.black))
        }else{
            holder. tvState!!.setBackgroundResource(R.drawable.bg_shape_ffffff)
            holder. tvState!!.setTextColor(activity.resources.getColor(R.color.black))
        }
        holder.itemView.setOnClickListener{
            mPostion = position
            listener.onClick(holder.tvState!!.text.toString())
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvState : TextView? = null
        init {
            tvState =  itemView.findViewById(R.id.tv_state)
        }
    }

}