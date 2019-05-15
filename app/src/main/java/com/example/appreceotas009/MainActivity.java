package com.example.appreceotas009;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button BtnAddRec = (Button) findViewById(R.id.btnAddRec);
        BtnAddRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,cadastro_receitas.class);
                startActivity(intent);
            }
        });

        Button BtnBuscRec = (Button) findViewById(R.id.btnBuscRec);
        BtnBuscRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,busca_receitas.class);
                startActivity(intent);
            }
        });

        Button BtnListRec = (Button) findViewById(R.id.btnListRec);
        BtnListRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,lista_receitas.class);
                startActivity(intent);
            }
        });

    }
}
