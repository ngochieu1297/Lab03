package com.example.admin.lab03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnSendMsg, btnOpenWeb, btnOpenMap;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSendMsg = findViewById(R.id.btnSendMsg);
        btnOpenMap = findViewById(R.id.btnOpenMap);
        btnOpenWeb = findViewById(R.id.btnOpenWeb);
        txtView = findViewById(R.id.txtView);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0976014869"));
                startActivity(dialIntent);
            }
        });

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMsgIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms://0976014869"));
                startActivity(sendMsgIntent);
            }
        });

        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tlu.edu.vn/"));
                startActivity(openWebIntent);
            }
        });

        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:21.009355,105.824391"));
                startActivity(openMapIntent);
            }
        });
    }
}
