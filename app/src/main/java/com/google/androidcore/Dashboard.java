package com.google.androidcore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.androidcore.ViewModel.RegisterViewModel;
import com.google.androidcore.models.Register;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    RegisterRecyclerAdapter adapter;
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //---------------------------------------------
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

        //-------------
        initializeDisplayContent();

    }

    //initializing display content for the recycler view
    private void initializeDisplayContent() {

        //display content
        //finding the recycler view by id
        final RecyclerView displayStuff = findViewById(R.id.recycle_lay);

        //setting the type of layout manager for the recycler view
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        displayStuff.setLayoutManager(linearLayoutManager);

        //instantiating the Comment recycler adapter so as to set the adapter type
        adapter = new RegisterRecyclerAdapter(this);
        displayStuff.setAdapter(adapter);

        registerViewModel.getAllRegister().observe(this, registers -> adapter.setRegister(registers));
    }
}