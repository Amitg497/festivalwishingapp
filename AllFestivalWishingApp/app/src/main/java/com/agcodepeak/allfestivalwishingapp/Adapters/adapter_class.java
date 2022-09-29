package com.agcodepeak.allfestivalwishingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agcodepeak.allfestivalwishingapp.R;
import com.agcodepeak.allfestivalwishingapp.models.model_class;

import java.util.ArrayList;

public class adapter_class extends RecyclerView.Adapter<adapter_class.viewholder>{


    ArrayList<model_class> list;
    Context context;

    public adapter_class(ArrayList<model_class> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycler,parent,false);


        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        model_class model = list.get(position);
        holder.imageView.setImageResource(model.getFestiv());
        holder.textView.setText(model.getNemo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.aaImageview);
            textView = itemView.findViewById(R.id.aaTextview);
        }
    }
}
