package com.example.izhuatl.ui.irrigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.izhuatl.databinding.FragmentHomeBinding;
import com.example.izhuatl.databinding.FragmentIrrigationBinding;

public class IrrigationFragment extends Fragment {

    private FragmentIrrigationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        IrrigationViewModel irrigationViewModel =
                new ViewModelProvider(this).get(IrrigationViewModel.class);

        binding = FragmentIrrigationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}