package com.example.rebook.launch.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.R;
import com.example.rebook.launch.HomePageModel;
import com.example.rebook.launch.HorizontalProductScrollModel;
import com.example.rebook.launch.SliderModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_categories);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        categoryRecyclerView = findViewById(R.id.category_recyclerview);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //////////////////////////////////////////////// banner silder

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ad_banner2, "#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.question_paper,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner1, "#671919"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner4, "#00ff00"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner2, "#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.question_paper,"#ffffff"));


        sliderModelList.add(new SliderModel(R.drawable.ad_banner1, "#671919"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner4, "#00ff00"));

     //   SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);    //todo:check this line

        /////////////////////////////////////////////////// banner slider

        ////////////////////////////////////////////////// strip ad layout

        //////////////////////////////////////////////////strip ad

        ///////////////////////////////categoryRecyclerView////////////////////horizontal product layout

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
        ///////////////////////////////////////////////////horizontal product layout


        //////////////////////////////////////Grid Product layout

        /////////////////////////////////////Grid product layout

        ////////////////////////////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ad_banner, "#B3A251"));
        homePageModelList.add(new HomePageModel(2, "Maha Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ad_banner5, "#006064"));
        homePageModelList.add(new HomePageModel(2, "Lovely Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Teacher Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.minibanner_romantic, "#D631CE"));
        homePageModelList.add(new HomePageModel(3, "Some Special Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.question_paper, "#1A237E"));
        homePageModelList.add(new HomePageModel(2, "student Deals", horizontalProductScrollModelList));

        homePageModelList.add(new HomePageModel(1, R.drawable.romance_category, "#E65100"));



        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        }
        else if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
