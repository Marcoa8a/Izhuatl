package com.example.izhuatl.ui.lumenes;

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
import com.example.izhuatl.databinding.FragmentLumenesBinding;

public class LumenesFragment extends Fragment {

    private FragmentLumenesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LumenesViewModel lumenesViewModel =
                new ViewModelProvider(this).get(LumenesViewModel.class);

        binding = FragmentLumenesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}