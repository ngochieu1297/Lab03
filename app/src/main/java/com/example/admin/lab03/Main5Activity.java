package com.example.admin.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {
    EditText edtSoA, edtSoB;
    Button btnSendNumber, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnSendNumber = findViewById(R.id.btnSendNumber);
        btnCancel = findViewById(R.id.btnCancel);

        btnSendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("SoA", edtSoA.getText().toString());
                i.putExtra("SoB", edtSoB.getText().toString());
                setResult(Main4Activity.RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Main4Activity.RESULT_CANCEL);
                finish();
            }
        });
    }
}
