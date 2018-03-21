package com.example.admin.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button btnGetNumber;
    TextView txtSoA, txtSoB, txtSum;
    public static int RESULT_OK = 1;
    public static int RESULT_CANCEL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnGetNumber = findViewById(R.id.btnGetNumber);
        txtSoA = findViewById(R.id.txtSoA);
        txtSoB = findViewById(R.id.txtSoB);
        txtSum = findViewById(R.id.txtSum);

        btnGetNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();
            }
        });
    }

    public void getNumber() {
        Intent i = new Intent(Main4Activity.this, Main5Activity.class);
        startActivityForResult(i, 1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1001) {
            if(resultCode == RESULT_OK) {
                String a = data.getStringExtra("SoA");
                String b = data.getStringExtra("SoB");
                txtSoA.setText(a);
                txtSoB.setText(b);
                int sum = Integer.parseInt(a) + Integer.parseInt(b);
                txtSum.setText("Tổng : " + sum);
                Toast.makeText(Main4Activity.this, "Trả về thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Main4Activity.this, "Trả về thất bại", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
