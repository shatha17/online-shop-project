package com.example.shopforeveryone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    List<ItemData> list;
    Context context;

    public CartAdapter(List<ItemData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        ItemData data=list.get(position);
        holder.image.setBackgroundResource(data.getImage());
        holder.itemname.setText(data.getTitle());
        holder.price.setText(data.getPrice()+" JD");
        holder.number.setText(data.getNumber()+"");

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=data.getNumber()+1;
                OrderList.list.get(position).setNumber(num);
                data.setNumber(num);
                holder.number.setText(data.getNumber()+"");
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.getNumber()!=0) {
                    int num = data.getNumber() - 1;
                    OrderList.list.get(position).setNumber(num);
                    data.setNumber(num);
                    holder.number.setText(data.getNumber() + "");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView itemname,price,number;
        ImageButton plus,minus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            itemname=itemView.findViewById(R.id.itemname);
            price=itemView.findViewById(R.id.price);
            number=itemView.findViewById(R.id.number);
            plus=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
        }
    }
}
