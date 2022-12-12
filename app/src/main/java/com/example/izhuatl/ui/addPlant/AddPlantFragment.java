package com.example.izhuatl.ui.addPlant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.izhuatl.databinding.FragmentAddPlantBinding;

public class AddPlantFragment extends Fragment{
    private FragmentAddPlantBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AddPlantViewModel addPlantViewModel =
                new ViewModelProvider(this).get(AddPlantViewModel.class);

        binding = FragmentAddPlantBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showPlant(View view) {

    }

}
