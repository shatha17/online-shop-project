package com.example.shopforeveryone;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KidsTabFragment extends Fragment {
    ItemAdapter adapter;
    List<Integer> img=new ArrayList<>();
    RecyclerView recycleView;
    ImageButton more;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.kids_tab_fragment,container,false);

        img.add(R.drawable.kids_items1);
        img.add(R.drawable.kids_items2);
        img.add(R.drawable.kids_items3);
        recycleView=root.findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(KidsTabFragment.super.getContext()
                , LinearLayoutManager.HORIZONTAL, false));
        adapter=new ItemAdapter(img);
        recycleView.setAdapter(adapter);

        more=root.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(KidsTabFragment.super.getContext(),ItemList.class);
                intent.putExtra("type","kids");
                startActivity(intent);
            }
        });

        return root;
    }
}
