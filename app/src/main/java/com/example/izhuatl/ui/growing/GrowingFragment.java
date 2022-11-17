package com.example.izhuatl.ui.growing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.izhuatl.databinding.FragmentGrowingBinding;


public class GrowingFragment extends Fragment {

    private FragmentGrowingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GrowingViewModel growingViewModel =
                new ViewModelProvider(this).get(GrowingViewModel.class);

        binding = FragmentGrowingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGrowing;
        growingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}