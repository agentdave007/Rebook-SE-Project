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
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        wishlistRecyclerView=view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList= new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.python_programming,"Python Programming",2,"4",10,"300","600","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.novel_book,"The Positive Dog",0,"4",100,"300","600","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.dmbs,"Python Programming",1,"4",14,"300","600","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.java_programming,"Java Programming",2,"4",1,"300","600","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.python_programming,"Python Programming",5,"4",10,"300","600","Cash on Delivery"));

        WishlistAdapter wishlistAdapter= new WishlistAdapter(wishlistModelList,true);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;
    }

}
