package com.example.midterm_brian_pagsolingan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> tableList;          // class-level
    private ArrayAdapter<Integer> adapter;    // class-level

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

        tableList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableList);
        multTable.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            String inputText = intinput.getText().toString().trim();

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
            }

            int number;
            try {
                number = Integer.parseInt(inputText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
                return;
            }

            tableList.clear();
            for (int i = 1; i <= 10; i++) {
                tableList.add(number * i);
            }
            adapter.notifyDataSetChanged();
        });

        multTable.setOnItemClickListener((parent, view, position, id) -> {
            int selectedItem = tableList.get(position);

            new AlertDialog.Builder(this)
                    .setTitle("Delete item")
                    .setMessage("Do you want to delete " + selectedItem + "?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        tableList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "Deleted: " + selectedItem, Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }
}