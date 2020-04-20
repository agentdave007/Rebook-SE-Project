package com.example.rebook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.launch.MyOrderAdapter;
import com.example.rebook.launch.MyorderItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }
    private RecyclerView myOrderRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
        myOrderRecyclerView= view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyorderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyorderItemModel(R.drawable.python_programming,2,"Python Programming"," Delivered on 30 Nov 2020"));
        myOrderItemModelList.add(new MyorderItemModel(R.drawable.java_programming,0,"Java Programming"," Delivered on 30 Nov 2020"));
        myOrderItemModelList.add(new MyorderItemModel(R.drawable.motivation_book,4,"Make your own waves","Cancelled"));
        myOrderItemModelList.add(new MyorderItemModel(R.drawable.novel_book,3,"The Positive Dog "," Delivered on 30 Nov 2020"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();
        return view;
    }

}
