package com.example.viewpager2withanimations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.example.viewpager2withanimations.databinding.ActivityViewFragmentTabBinding;
import com.example.viewpager2withanimations.fragments.EventsFragment;
import com.example.viewpager2withanimations.fragments.MoviesFragment;
import com.example.viewpager2withanimations.fragments.TicketsFragment;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewFragmentTab extends AppCompatActivity {

    ActivityViewFragmentTabBinding binding;

    private final String[] titles = new String[]{"Movies", "Events", "Tickets"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewFragmentTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        //

    }

    private void init() {

        binding.viewPager.setAdapter(new FragmentPagerAdapter(this));

        binding.viewPager.setPageTransformer(Utils.getTransformer(R.id.action_vertical_flip));

        binding.springDotsIndicator.setViewPager2(binding.viewPager);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,(tab, position) -> tab.setText(titles[position])).attach();

//        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> tab.setText(titles[position])).attach();

    }

    private class FragmentPagerAdapter extends FragmentStateAdapter {

        public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new MoviesFragment();
                case 1:
                    return new EventsFragment();
                case 2:
                    return new TicketsFragment();
            }
            return new Fragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }

}