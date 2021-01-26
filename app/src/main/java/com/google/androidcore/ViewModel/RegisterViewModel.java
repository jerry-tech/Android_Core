package com.google.androidcore.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.androidcore.models.Register;
import com.google.androidcore.repository.RegisterRepository;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {

    private RegisterRepository registerRepository;
    private LiveData<List<Register>> mRegister;

    public RegisterViewModel(@NonNull Application application) {
        super(application);

        registerRepository = new RegisterRepository(application);
        mRegister = registerRepository.getAllRegister();
    }

    public LiveData<List<Register>> getAllRegister(){
        return mRegister;
    }

    public void insertRegister(Register register){
        registerRepository.insert(register);
    }
}
