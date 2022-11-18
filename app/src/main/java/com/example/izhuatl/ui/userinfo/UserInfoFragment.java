package com.example.izhuatl.ui.userinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.izhuatl.R;
import com.example.izhuatl.RecoverAccount;
import com.example.izhuatl.databinding.FragmentGalleryBinding;
import com.example.izhuatl.ui.details.DetailsFragment;

public class UserInfoFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserInfoViewModel userInfoViewModel =
                new ViewModelProvider(this).get(UserInfoViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Direcciona a otra activity
        Button btnBackLogin = (Button) root.findViewById(R.id.btn_back_more_info);
        btnBackLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), RecoverAccount.class);
                startActivity(intent);
            }
        });

        /*Direcionamiento de imagen amapola a detalles
        ImageView imageViewDetails = (ImageView) root.findViewById(R.id.image_amapola);
        imageViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsFragment.class);
                startActivity(intent);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showDetailsAmapola(View view) {
    }
}
