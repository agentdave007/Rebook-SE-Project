package com.example.rebook.launch.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.R;
import com.example.rebook.launch.CategoryAdapter;
import com.example.rebook.launch.CategoryModel;
import com.example.rebook.launch.HomePageModel;
import com.example.rebook.launch.HorizontalProductScrollModel;
import com.example.rebook.launch.SliderAdapter;
import com.example.rebook.launch.SliderModel;
import com.example.rebook.launch.ui.HomePageAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        })*/
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        final List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Textbook"));
        categoryModelList.add(new CategoryModel("link", "References"));
        categoryModelList.add(new CategoryModel("link", "Romance"));
        categoryModelList.add(new CategoryModel("link", "Fantasy"));
        categoryModelList.add(new CategoryModel("link", "Action"));
        categoryModelList.add(new CategoryModel("link", "Horror"));
        categoryModelList.add(new CategoryModel("link", "Journals"));
        categoryModelList.add(new CategoryModel("link", "Tenyears"));
        categoryModelList.add(new CategoryModel("link", "Competitive"));
        categoryModelList.add(new CategoryModel("link", "Miscellaneous"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        //////////////////////////////////////////////// banner silder

        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.drawable.ad_banner1, "#671919"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner4, "#00ff00"));
        sliderModelList.add(new SliderModel(R.drawable.ad_banner2, "#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.question_paper,"#ffffff"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);

        /////////////////////////////////////////////////// banner slider

        ////////////////////////////////////////////////// strip ad layout

        //////////////////////////////////////////////////strip ad

        ///////////////////////////////////////////////////horizontal product layout

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

        ///////////////////////////////////////////////////horizontal product layout


        //////////////////////////////////////Grid Product layout

        /////////////////////////////////////Grid product layout

        ////////////////////////////////
        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ad_banner, "#50F1EC"));
        homePageModelList.add(new HomePageModel(2, "Lovely Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.minibanner_romantic, "#CDE781CE"));
        homePageModelList.add(new HomePageModel(2, "student Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ad_banner5, "#004D40"));
        homePageModelList.add(new HomePageModel(3, "Teacher Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.minibanner_savepaper, "#1B5E20"));
        homePageModelList.add(new HomePageModel(3, "Rebook Deals", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.ad_banner4, "#6CAFF7"));




        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////////////////////////
        return view;

    }

}