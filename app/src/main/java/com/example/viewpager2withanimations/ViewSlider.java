package com.example.viewpager2withanimations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.viewpager2withanimations.databinding.ActivityViewSliderBinding;

public class ViewSlider extends AppCompatActivity {

    private ActivityViewSliderBinding binding;
    private int[] layout;
    private int[] dots;
    private ViewSliderAdapter mAdapter;
    private ImageView[] ivArrayDotsPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewSliderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        layout = new int[]{
                R.layout.slide_one,
                R.layout.slide_two,
                R.layout.slide_three,
                R.layout.slide_four
        };

        //initialising adapter
        mAdapter = new ViewSliderAdapter();
        //Setting Adapter
        binding.viewPager.setAdapter(mAdapter);
        binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback);

        binding.springDotsIndicator.setViewPager2(binding.viewPager);
        //Setting up navigation dots
        setUpDots();

        binding.btnSkip.setOnClickListener(view -> launchHomeScreen());

        binding.btnNext.setOnClickListener(view -> {
            int current = binding.viewPager.getCurrentItem() + 1;
            if (current < layout.length) {
                //move to the next screen
                binding.viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }
        });

        binding.icMore.setOnClickListener(view -> showPopUpMenu(view));


    }

    ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);

            if (position == layout.length - 1) {
                binding.btnSkip.setVisibility(View.GONE);
                binding.btnNext.setText(getResources().getString(R.string.finish));
            } else {
                binding.btnNext.setText(getResources().getString(R.string.next));
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
            updatingDotsLayout(position);
        }
    };

    private void updatingDotsLayout(int position) {
        for (int i = 0; i < layout.length; i++) {
            ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
        }
        ivArrayDotsPager[position].setImageResource(R.drawable.selected);
    }

    private void setUpDots() {
        ivArrayDotsPager = new ImageView[layout.length];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
            if (i == 0) {
                ivArrayDotsPager[i].setImageResource(R.drawable.selected);
//                ivArrayDotsPager[i].setBackgroundColor(getResources().getColor(R.color.black));
            }
            ivArrayDotsPager[i].setOnClickListener(view -> view.setAlpha(1));
            binding.llPagerDots.addView(ivArrayDotsPager[i]);
//            binding.llPagerDots.bringToFront();
        }
    }

    private void launchHomeScreen() {
//        View rootView =((ViewSlider) this).getWindow().getDecorView().findViewById(R.id.content);
//        View view = rootView.findViewById(R.id.coordinatorLayout);
//        Snackbar snackbar = Snackbar.make(view, R.string.slides_ended, Snackbar.LENGTH_SHORT);
//        snackbar.show();

        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_SHORT).show();
        //finishing the ViewSliderActivity
        finish();
    }

    private void showPopUpMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.page_transformations, popup.getMenu());
        popup.setOnMenuItemClickListener(menuItem -> {
            if (menuItem.getItemId() == R.id.action_orientation) {
                if (binding.viewPager.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                } else {
                    binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }
            } else {
                binding.viewPager.invalidate();
                binding.viewPager.setAdapter(mAdapter);
                binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback);
                binding.viewPager.setPageTransformer(Utils.getTransformer(menuItem.getItemId()));
            }
            return false;
        });
        popup.show();
    }


    public class ViewSliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public ViewSliderAdapter() {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
            return new SliderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemViewType(int position) {
            return layout[position];
        }

        @Override
        public int getItemCount() {
            return layout.length;
        }

        public class SliderViewHolder extends RecyclerView.ViewHolder {

            public SliderViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

    }

}