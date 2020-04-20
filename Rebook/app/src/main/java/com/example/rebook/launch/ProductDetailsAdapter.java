package com.example.rebook.launch;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDetailsAdapter extends FragmentPagerAdapter {
    private int totalTabs;

    public ProductDetailsAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProductsDescriptionsFragment productDescriptionFragment1= new ProductsDescriptionsFragment();
                return productDescriptionFragment1;

            case 1:
                ProductSpecificationFragment productSpecificationFragment= new ProductSpecificationFragment();
                return productSpecificationFragment;
            case 2:
                ProductsDescriptionsFragment productDescriptionFragment2= new ProductsDescriptionsFragment();
                return productDescriptionFragment2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
