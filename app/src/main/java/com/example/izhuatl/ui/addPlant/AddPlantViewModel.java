package com.example.izhuatl.ui.addPlant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPlantViewModel extends ViewModel{

    private final MutableLiveData<String> mText;

    public AddPlantViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
