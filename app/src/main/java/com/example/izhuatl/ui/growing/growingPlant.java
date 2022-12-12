package com.example.izhuatl.ui.growing;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.izhuatl.AddPlant;
import com.example.izhuatl.R;
import com.example.izhuatl.databinding.FragmentGrowingPlantBinding;

public class growingPlant extends Fragment {

    private FragmentGrowingPlantBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        GrowingPlantViewModel growingPlantViewModel =
                new ViewModelProvider(this).get(GrowingPlantViewModel.class);

        binding = FragmentGrowingPlantBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = (Button) root.findViewById(R.id.buttonIns);

        button.setOnClickListener(view ->{
            button.setVisibility(View.GONE);
            addPlant();
        });

        return root;
    }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }

        public void addPlant() {
            Intent intent = new Intent(getActivity(), AddPlant.class);
            startActivity(intent);
        }


}