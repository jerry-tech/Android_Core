package com.google.androidcore.repository;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.google.androidcore.Dao.RegisterDao;
import com.google.androidcore.database.RegisterDatabase;
import com.google.androidcore.models.Register;

import java.util.List;

public class RegisterRepository {

    private RegisterDao registerDao;
    private LiveData<List<Register>> allRegister;

    public RegisterRepository(Application application) {
        RegisterDatabase db = RegisterDatabase.getDatabase(application);
        registerDao = db.registerDao();
        allRegister = registerDao.getAllRegister();
    }

    public LiveData<List<Register>> getAllRegister() {
        return allRegister;
    }

    public void insert (Register register) {
        new insertAsyncTask(registerDao).execute(register);
    }

    private static class insertAsyncTask extends AsyncTask<Register, Void, Void> {

        private final RegisterDao mAsyncTaskDao;

        insertAsyncTask(RegisterDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Register... params) {
            mAsyncTaskDao.insertRegistration(params[0]);
            return null;
        }
    }

}
