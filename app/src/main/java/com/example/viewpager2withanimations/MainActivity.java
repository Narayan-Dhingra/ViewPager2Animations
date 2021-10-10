package com.example.viewpager2withanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.viewpager2withanimations.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

    }

    private void init() {
        // Handling Click Event for button ViewSlider
        binding.btnViewSlider.setOnClickListener(view -> startActivity(new Intent(this, ViewSlider.class)));
        // Handling Click Event for button FragmentTab
        binding.btnFragmentTab.setOnClickListener(view -> startActivity(new Intent(this, ViewFragmentTab.class)));
    }

}