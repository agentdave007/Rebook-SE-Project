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
public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {
        // Required empty public constructor
    }
    private RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardsRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rewardsRecyclerView.setLayoutManager(layoutManager);
        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("CashBack"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Reward"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Prize"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Free item"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Discount"," till life comes to end ","Get item free but stay at home "));
        rewardModelList.add(new RewardModel("Buy one get one free"," till life comes to end ","Get item free but stay at home "));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList,false);
        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();



        return view;

    }

}
