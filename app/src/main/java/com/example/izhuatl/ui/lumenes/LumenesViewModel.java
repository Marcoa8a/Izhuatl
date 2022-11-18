package com.example.izhuatl.ui.lumenes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LumenesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LumenesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}