package com.example.admin.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView txtView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtView2 = findViewById(R.id.txtView2);
        Intent i = getIntent();
        String s = i.getStringExtra("info");
        txtView2.setText("Hello " + s);
    }
}
