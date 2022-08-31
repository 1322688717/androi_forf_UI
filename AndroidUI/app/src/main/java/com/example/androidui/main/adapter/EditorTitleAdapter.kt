package com.example.androidui.main.adapter

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.androidui.R
import java.util.ArrayList

class EditorTitleAdapter(
    var list_title: ArrayList<String>,
    var list_imge: ArrayList<Int>,
    var activity: Activity
) : RecyclerView.Adapter<EditorTitleAdapter.ViewHolder>() {
    var tv_title: TextView? = null
    var img_head: ImageView? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.editor_title_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tv_title!!.text = list_title[position]
        img_head!!.setImageResource(list_imge[position])
    }

    override fun getItemCount(): Int {
        return list_imge.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            tv_title = itemView.findViewById(R.id.tv_title)
            img_head = itemView.findViewById(R.id.img_head)
        }
    }
}