package com.example.rebook.launch;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.R;
import com.example.rebook.launch.ui.GridProductLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MahaDeals");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code", -1);


        if (layout_code == 0) {


            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.python_programming, "Python Programming", 2, "4", 10, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.learn_language, "Integrated Chinese", 0, "4", 100, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.motivation_book, "Growth Mindeset", 1, "4", 14, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.java_programming, "Java Programming", 2, "4", 1, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.novel_book, "Positive Dog", 5, "4", 10, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.python_programming, "Python Programming", 2, "4", 10, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.learn_language, "Integrated Chinese", 0, "4", 100, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.motivation_book, "Growth Mindeset", 1, "4", 14, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.java_programming, "Java Programming", 2, "4", 1, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.novel_book, "Positive Dog", 5, "4", 10, "300", "600", "Cash on Delivery"));

            wishlistModelList.add(new WishlistModel(R.drawable.python_programming, "Python Programming", 2, "4", 10, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.learn_language, "Integrated Chinese", 0, "4", 100, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.motivation_book, "Growth Mindeset", 1, "4", 14, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.java_programming, "Java Programming", 2, "4", 1, "300", "600", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.novel_book, "Positive Dog", 5, "4", 10, "300", "600", "Cash on Delivery"));
            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (layout_code == 1) {

            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.python_programming, "Python Programming", "TextBook", "Rs.499/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.make_your_waves, "Make your own waves", "Motivation", "Rs.299/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.motivation_book, "The Growth Mindset", "Motivation", "Rs.100/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.java_programming, "Java Programming", "TextBook", "Rs.100/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.novel_book, "The Positive Dog", "Novel", "Rs.130/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.learn_language, "Integrated Chinese", "Language", "Rs.1/-"));

            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.dmbs, "Database management", "TextBook", "Rs.199/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.python_programming, "Python Programming", "TextBook", "Rs.221/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.make_your_waves, "Make your own waves", "Motivation", "Rs.500/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.motivation_book, "The Growth Mindset", "Motivation", "Rs.551/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.java_programming, "Java Programming", "TextBook", "Rs.31/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.novel_book, "The Positive Dog", "Novel", "Rs.1/-"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.learn_language, "Integrated Chinese", "Language", "Rs.21/-"));

            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.dmbs, "Database management", "TextBook", "Rs.11/-"));


            gridView.setVisibility(View.VISIBLE);
            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
