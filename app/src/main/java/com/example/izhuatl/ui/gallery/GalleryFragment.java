package com.example.izhuatl.ui.gallery;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.izhuatl.AdPlantV;
import com.example.izhuatl.AddPlant;
import com.example.izhuatl.MoreInformation;
import com.example.izhuatl.MoreInformationB;
import com.example.izhuatl.MoreInformationM;
import com.example.izhuatl.MoreInformationT;
import com.example.izhuatl.MoreInformationTo;
import com.example.izhuatl.MoreInformationZ;
import com.example.izhuatl.R;
import com.example.izhuatl.databinding.FragmentGalleryBinding;
import com.example.izhuatl.ui.details.DetailsFragment;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button btn_add = root.findViewById(R.id.btn_addPlant);
        ImageView imagenTronco = (ImageView) root.findViewById(R.id.image_troncoB);
        ImageView imagenBromelia = (ImageView) root.findViewById(R.id.image_bromelia);
        ImageView imagenAmapola = (ImageView) root.findViewById(R.id.image_amapola);
        ImageView imagenManzanilla = (ImageView) root.findViewById(R.id.image_manzanilla);
        ImageView imagenTomate = (ImageView) root.findViewById(R.id.image_tomate);
        ImageView imagenZanahoria = (ImageView) root.findViewById(R.id.image_zanahoria);

        imagenTronco.setOnClickListener(view ->{
            imagenTronco.setVisibility(View.GONE);
            showDetailsTronco();
        });

        imagenBromelia.setOnClickListener(view ->{
            imagenBromelia.setVisibility(View.GONE);
            showDetailsBromelia();
        });

        imagenAmapola.setOnClickListener(view ->{
            imagenAmapola.setVisibility(View.GONE);
            showDetailsAmapola();
        });

        imagenManzanilla.setOnClickListener(view ->{
            imagenManzanilla.setVisibility(View.GONE);
            showDetailsManzanilla();
        });

        imagenTomate.setOnClickListener(view ->{
            imagenTomate.setVisibility(View.GONE);
            showDetailsTomate();
        });

        imagenZanahoria.setOnClickListener(view ->{
            imagenZanahoria.setVisibility(View.GONE);
            showDetailsZanahoria();
        });

        btn_add.setOnClickListener(view ->{
            btn_add.setVisibility(View.GONE);
            addPlant();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showDetailsAmapola() {
        Intent intent = new Intent(getActivity(), MoreInformation.class);
        startActivity(intent);
    }

    public void showDetailsBromelia(){
        Intent intent = new Intent(getActivity(), MoreInformationB.class);
        startActivity(intent);
    }

    public void showDetailsManzanilla(){
        Intent intent = new Intent(getActivity(), MoreInformationM.class);
        startActivity(intent);
    }

    public void showDetailsTronco(){
        Intent intent = new Intent(getActivity(), MoreInformationT.class);
        startActivity(intent);
    }

    public void showDetailsTomate(){
        Intent intent = new Intent(getActivity(), MoreInformationTo.class);
        startActivity(intent);
    }

    public void showDetailsZanahoria(){
        Intent intent = new Intent(getActivity(), MoreInformationZ.class);
        startActivity(intent);
    }

    public void addPlant() {
        Intent intent = new Intent(getActivity(), AdPlantV.class);
        startActivity(intent);
    }
}


























