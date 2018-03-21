package com.example.admin.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edt;
    Button btn_edit, btn_delete, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        edt = findViewById(R.id.edtName);
        btn_edit = findViewById(R.id.btnEdit);
        btn_delete = findViewById(R.id.btnDelete);
        btn_cancel = findViewById(R.id.btnCancel);
        btn_edit.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        Intent i = getIntent();
        String name = i.getStringExtra("person");
        edt.setText(name);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_edit) {
            Intent i = new Intent();
            i.putExtra("newPerson", edt.getText().toString());
            setResult(Main6Activity.EDIT, i);
            finish();
        }
        if(v == btn_cancel) {
            finish();
        }
        if (v == btn_delete) {
            setResult(Main6Activity.DELETE,null);
            finish();
        }
    }
}