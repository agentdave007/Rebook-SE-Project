package com.example.rebook.launch.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rebook.launch.HorizontalProductScrollModel;

import java.util.List;

import static com.example.rebook.R.id;
import static com.example.rebook.R.layout;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductScrollModel>  horizontalProductScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();  //to show any 4 items
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(layout.horizontal_scroll_item_layout,null);

            // todo:here is some code video number 27
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent= new Intent(parent.getContext(),com.example.rebook.launch.ProductDetailsActivity.class);
                    parent.getContext().startActivity(productDetailsIntent);
                }
            });
            ImageView productImage= view.findViewById(id.h_s_product_image);  // using horizontal scroll layout
            TextView productTitle =view.findViewById(id.h_s_product_title);
            TextView productDescription= view.findViewById(id.h_s_product_des_author);
            TextView productPrice= view.findViewById(id.h_s_product_price);


            productImage.setImageResource(horizontalProductScrollModelList.get(position).getProductImage());
            productTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProductScrollModelList.get(position).getProductDescription());
            productPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());
        }
        else{

            view = convertView;
        }
        return view;
    }
}
