package com.example.androidui.main.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidui.R;

import java.util.ArrayList;

public class EditorTitleAdapter extends RecyclerView.Adapter<EditorTitleAdapter.ViewHolder> {

    ArrayList<String> list_title;
    ArrayList<Integer> list_imge;
    Activity activity;
    TextView tv_title;
    ImageView img_head;


    public EditorTitleAdapter(ArrayList<String> list_title, ArrayList<Integer> list_imge, Activity activity) {
        this.list_title = list_title;
        this.list_imge = list_imge;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_title_item,parent,false);
        return new EditorTitleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        tv_title.setText(list_title.get(position));
        img_head.setImageResource(list_imge.get(position));
    }

    @Override
    public int getItemCount() {
        return list_imge.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_head = itemView.findViewById(R.id.img_head);
        }
    }
}
