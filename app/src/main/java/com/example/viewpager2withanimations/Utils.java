package com.example.viewpager2withanimations;

import android.annotation.SuppressLint;

import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2withanimations.transformers.AntiClockSpinTransformation;
import com.example.viewpager2withanimations.transformers.ClockSpinTransformation;
import com.example.viewpager2withanimations.transformers.CubeInDepthTransformation;
import com.example.viewpager2withanimations.transformers.CubeInRotationTransformation;
import com.example.viewpager2withanimations.transformers.CubeOutDepthTransformation;
import com.example.viewpager2withanimations.transformers.CubeOutRotationTransformation;
import com.example.viewpager2withanimations.transformers.CubeOutScalingTransformation;
import com.example.viewpager2withanimations.transformers.DepthPageTransformer;
import com.example.viewpager2withanimations.transformers.DepthTransformation;
import com.example.viewpager2withanimations.transformers.FadeOutTransformation;
import com.example.viewpager2withanimations.transformers.FanTransformation;
import com.example.viewpager2withanimations.transformers.GateTransformation;
import com.example.viewpager2withanimations.transformers.HingeTransformation;
import com.example.viewpager2withanimations.transformers.HorizontalFlipTransformation;
import com.example.viewpager2withanimations.transformers.PopTransformation;
import com.example.viewpager2withanimations.transformers.SimpleTransformation;
import com.example.viewpager2withanimations.transformers.SpinnerTransformation;
import com.example.viewpager2withanimations.transformers.TossTransformation;
import com.example.viewpager2withanimations.transformers.VerticalFlipTransformation;
import com.example.viewpager2withanimations.transformers.VerticalShutTransformation;
import com.example.viewpager2withanimations.transformers.ZoomOutPageTransformer;

public class Utils {

    @SuppressLint("NonConstantResourceId")
    public static ViewPager2.PageTransformer getTransformer(int id) {
        switch (id) {
            case R.id.action_anti_clock_spin:
                return new AntiClockSpinTransformation();
            case R.id.action_clock_spin:
                return new ClockSpinTransformation();
            case R.id.action_cube_in_depth:
                return new CubeInDepthTransformation();
            case R.id.action_cube_in_rotate:
                return new CubeInRotationTransformation();
            case R.id.action_cube_out_depth:
                return new CubeOutDepthTransformation();
            case R.id.action_cube_out_rotate:
                return new CubeOutRotationTransformation();
            case R.id.action_cube_out_scaling:
                return new CubeOutScalingTransformation();
            case R.id.action_depth_page:
                return new DepthPageTransformer();
            case R.id.action_depth:
                return new DepthTransformation();
            case R.id.action_fade_out:
                return new FadeOutTransformation();
            case R.id.action_fan:
                return new FanTransformation();
            case R.id.action_gate:
                return new GateTransformation();
            case R.id.action_hinge:
                return new HingeTransformation();
            case R.id.action_horizontal_flip:
                return new VerticalFlipTransformation();
            case R.id.action_pop:
                return new PopTransformation();
            case R.id.action_simple_transformation:
                return new SimpleTransformation();
            case R.id.action_spinner:
                return new SpinnerTransformation();
            case R.id.action_toss:
                return new TossTransformation();
            case R.id.action_vertical_flip:
                return new HorizontalFlipTransformation();
            case R.id.action_vertical_shut:
                return new VerticalShutTransformation();
            case R.id.action_zoom_out:
                return new ZoomOutPageTransformer();

        }
        return null;
    }

}

