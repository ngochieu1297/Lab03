package com.example.admin.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btnSendTo;
    TextView txtView1;
    EditText edtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSendTo = findViewById(R.id.btnSendTo);
        txtView1 = findViewById(R.id.txtView1);
        edtText = findViewById(R.id.edtText);

        btnSendTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("info", edtText.getText() + "");
                startActivity(i);
            }
        });
    }
}
