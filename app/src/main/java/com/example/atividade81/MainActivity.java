package com.example.atividade81;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.navigation.Navigation;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToBlackFragment = findViewById(R.id.btnGoToBlackFragment);
        btnGoToBlackFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar para o fragmento 'blackFragment'
                Navigation.findNavController(v).navigate(R.id.navegacao);
            }
        });
    }
}