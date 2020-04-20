package com.example.rebook.launch;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationRecyclerView= view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList= new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"PDF availabe","No"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"weight","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Dimension","30*30*10"));

        productSpecificationModelList.add(new ProductSpecificationModel(0,"Specific"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Rebook Rating","Excellent"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Graphics","Good"));


        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));

        productSpecificationModelList.add(new ProductSpecificationModel(0,"Specific"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"NUMPAGE","490"));


        ProductionSpecificationAdapter productionSpecificationAdapter= new ProductionSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerView.setAdapter(productionSpecificationAdapter);
        productionSpecificationAdapter.notifyDataSetChanged();

        return view;
    }

}
