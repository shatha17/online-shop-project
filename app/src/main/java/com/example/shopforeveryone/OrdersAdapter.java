package com.example.shopforeveryone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    List<List<ItemData>> list;
    List<String> states;
    List<Integer> totals;
    Context context;

    public OrdersAdapter(List<List<ItemData>> list, List<String> states, List<Integer> totals, Context context) {
        this.list = list;
        this.states = states;
        this.totals = totals;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder holder, int position) {
        if(states.get(position).equals("Completed")) {
            List<ItemData> data = list.get(position);

            int num=0;
            for (ItemData data1:data){
                num+=data1.getNumber();
            }

            holder.products.setText(num + " Product");
            holder.totalPrice.setText("Total Price = " + totals.get(position) + " JD");
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    totals.remove(position);
                    states.remove(position);

                    OrdersData.setAllOrderLists(list);
                    OrdersData.setAllTotals(totals);
                    OrdersData.setAllStates(states);

                    //context.startActivity(context.getIntent());
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView products,totalPrice,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            products=itemView.findViewById(R.id.products);
            totalPrice=itemView.findViewById(R.id.totalPrice);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
