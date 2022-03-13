package com.example.switch_book.Controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.switch_book.ItemFragment;
import com.example.switch_book.MainFragment;
import com.example.switch_book.SearchFragment;
import com.example.switch_book.SwitchFragment;

public class PagerController extends FragmentPagerAdapter {
    int numoftabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new SwitchFragment();
            case 2:
                return new ItemFragment();
            case 3:
                return new SearchFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
