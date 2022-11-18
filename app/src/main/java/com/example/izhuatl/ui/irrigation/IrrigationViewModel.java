package com.example.izhuatl.ui.irrigation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IrrigationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IrrigationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}