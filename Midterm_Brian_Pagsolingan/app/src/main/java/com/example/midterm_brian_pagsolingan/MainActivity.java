package com.example.midterm_brian_pagsolingan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    EditText intinput = findViewById(R.id.etInput);
    Button btnSubmit = findViewById(R.id.btnSubmit);
    ListView multTable = findViewById(R.id.lvItems);

    btnSubmit.setOnClickListener(v ->{
        String inpuText = intinput.getText().toString().trim();

        if(inpuText.isEmpty()){
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int number;
        try{
            number = Integer.parseInt(inpuText);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
            return;
        }

        List<Integer> tableList = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            tableList.add(number * i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, tableList);
        multTable.setAdapter(adapter);
    });

    }
}