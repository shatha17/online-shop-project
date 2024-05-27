package com.example.shopforeveryone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.viewHolder> {
    List<ItemData> itemData;
    Context context;

    public ItemListAdapter(List<ItemData> itemData, Context context) {
        this.itemData = itemData;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.viewHolder holder, int position) {
        ItemData data=itemData.get(position);
        holder.image.setBackgroundResource(data.getImage());
        holder.itemname.setText(data.getTitle());
        holder.price.setText(data.getPrice()+" JD");
        holder.number.setText(data.getNumber()+"");
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ViewItem.class);
                intent.putExtra("type",data.getType());
                intent.putExtra("image",data.getImage());
                intent.putExtra("title",data.getTitle());
                intent.putExtra("price",(data.getPrice()+""));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView itemname,price,number;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            itemname=itemView.findViewById(R.id.itemname);
            price=itemView.findViewById(R.id.price);
            number=itemView.findViewById(R.id.number);
        }
    }
}
