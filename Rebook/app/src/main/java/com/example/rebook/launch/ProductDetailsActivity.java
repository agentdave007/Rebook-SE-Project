package com.example.rebook.launch;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.rebook.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.rebook.launch.MainActivity.showCart;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewpagerIndicator;
    private static boolean ALREADY_ADD_TO_WISHLIST = false;
    private FloatingActionButton addToWishlistBtn;
    private ViewPager productDetailsViewpager;
    private TabLayout productDetailsTablayout;

    private Button coupenRedeemBtn;
    ///////////////////////////////coupen dialog
    public static TextView coupenTitle;
    public static TextView coupenBody;
    public static TextView coupenExpiryDate;
    private static RecyclerView coupensRecyclerView;
    private static LinearLayout selectedCoupen;
    ///////////////////////////////coupen dialog
    //////////////////////////Rating layout
    private LinearLayout rateNowContainer;

    ///////////////////////Rating layout

    private Button buyNowBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        buyNowBtn = findViewById(R.id.buy_now_btn);
        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishlistBtn = findViewById(R.id.add_to_wishlist_button);

        productDetailsViewpager = findViewById(R.id.product_details_viewpager);
        productDetailsTablayout = findViewById(R.id.product_detail_tablayout);

        coupenRedeemBtn = findViewById(R.id.coupon_redemption_btn);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.python_programming);
        productImages.add(R.drawable.author_photo);
        productImages.add(R.drawable.naveen_kumar_python);
        productImages.add(R.drawable.sheetal_taneja_python);
        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);
        viewpagerIndicator.setupWithViewPager(productImagesViewPager, true);

        addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADD_TO_WISHLIST) {
                    ALREADY_ADD_TO_WISHLIST = false;
                    addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                } else {
                    ALREADY_ADD_TO_WISHLIST = true;
                    addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimaryDark));
                }
            }
        });

        productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTablayout.getTabCount()));
        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            {
            }

            ;

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ////////Rating layout
        rateNowContainer = findViewById(R.id.rate_now_container);
        for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }

        ////////Rating layout

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getApplicationContext(), com.example.rebook.launch.DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });
        ////////////////////////////// coupen dialog
        final Dialog checkCoupenPriceDialog = new Dialog(ProductDetailsActivity.this);
        checkCoupenPriceDialog.setContentView(R.layout.coupen_redeem_dialog);
        checkCoupenPriceDialog.setCancelable(true);
        checkCoupenPriceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView toggleRecyclerView = checkCoupenPriceDialog.findViewById(R.id.toggle_recyclerView);
        coupensRecyclerView = checkCoupenPriceDialog.findViewById(R.id.coupens_recyclerview);
        selectedCoupen = checkCoupenPriceDialog.findViewById(R.id.selected_coupen);

        coupenTitle = checkCoupenPriceDialog.findViewById(R.id.coupen_title);
        coupenExpiryDate = checkCoupenPriceDialog.findViewById(R.id.coupen_validity);
        coupenBody = checkCoupenPriceDialog.findViewById(R.id.coupen_body);


        TextView originalPrice = checkCoupenPriceDialog.findViewById(R.id.original_price);
        TextView discountedPrice = checkCoupenPriceDialog.findViewById(R.id.discounted_price);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailsActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        coupensRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("CashBack", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Reward", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount", " till life comes to end ", "Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free", " till life comes to end ", "Get item free but stay at home "));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList, true);
        coupensRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        toggleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogRecyclerView();
            }
        }) ;
                   ////////////////////////////// coupen dialog

        coupenRedeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkCoupenPriceDialog.show();


            }
        });


    }

    public static void showDialogRecyclerView() {
        if (coupensRecyclerView.getVisibility() == View.GONE) {
            coupensRecyclerView.setVisibility(View.VISIBLE);
            selectedCoupen.setVisibility(View.GONE);
        } else {
            coupensRecyclerView.setVisibility(View.GONE);
            selectedCoupen.setVisibility(View.VISIBLE);
        }

    }

    private void setRating(int starPosition) {
        for (int x = 0; x < rateNowContainer.getChildCount(); x++) {
            ImageView starBtn = (ImageView) rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x <= starPosition) {
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        } else if (id == R.id.main_cart_icon) {
            //todo:remove this intent line add cart
            Intent cartIntent = new Intent(getApplicationContext(), MainActivity.class);
            showCart = true;
            startActivity(cartIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
