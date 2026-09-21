package com.example.notatki;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTytul, editTextTresc;
    private Button buttonDodaj;
    private ListView listaNotatki;
    private ArrayList<String> listaDanych;
    private ArrayAdapter<String> adapter;

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

        editTextTytul = findViewById(R.id.editTextTytulNotatki);
        editTextTresc = findViewById(R.id.editTextTrescNotatki);
        buttonDodaj = findViewById(R.id.buttonDodaj);
        listaNotatki = findViewById(R.id.listaNotatki);

        listaDanych = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDanych);
        listaNotatki.setAdapter(adapter);

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tytul = editTextTytul.getText().toString();
                String tresc = editTextTresc.getText().toString();

                if (!tytul.isEmpty() && !tresc.isEmpty()) {
                    String calosc = tytul + "\n" + tresc;
                    listaDanych.add(calosc);

                    adapter.notifyDataSetChanged();

                    editTextTytul.setText("");
                    editTextTresc.setText("");
                }
            }
        });
    }
}