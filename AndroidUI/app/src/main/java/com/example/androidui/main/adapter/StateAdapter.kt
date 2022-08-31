package com.example.androidui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R

class StateAdapter(var stateList: MutableList<String>) : RecyclerView.Adapter<StateAdapter.ViewHolder>() {

    var tvState : TextView? = null
    private var mPostion : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.state_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tvState!!.text = stateList[position]
        if (mPostion == position){
            tvState!!.background =  R.drawable.bg_shap_af94e6
        }

    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            tvState =  itemView.findViewById(R.id.tv_state)
        }
    }

}