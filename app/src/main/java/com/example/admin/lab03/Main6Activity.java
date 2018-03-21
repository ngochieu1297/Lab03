package com.example.admin.lab03;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    ArrayList<Person> arr;
    ArrayAdapter<Person> adapter;
    ListView lst;
    int index;
    public static final int EDIT = 1;
    public static final int DELETE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        arr = new ArrayList<>();
        arr.add(new Person("Nguyen Van An"));
        arr.add(new Person("Tran van Binh"));
        arr.add(new Person("Phan Van Cuong"));
        adapter = new ArrayAdapter(Main6Activity.this, android.R.layout.simple_list_item_1, arr);
        lst = findViewById(R.id.lsvShowName);
        lst.setAdapter(adapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Main6Activity.this);
                alert.setTitle("Insert new person");
                alert.setIcon(android.R.drawable.ic_input_add);
                alert.setMessage("Enter name");
                final EditText edt=new EditText(Main6Activity.this);
                alert.setView(edt);
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = edt.getText().toString();
                        arr.add(new Person(name));
                        adapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                Intent intent = new Intent(Main6Activity.this, Main7Activity.class);
                intent.putExtra("person", arr.get(i).getName());
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if(resultCode == EDIT) {
                Person p = new Person();
                p.setName(data.getStringExtra("newPerson"));
                arr.set(index, p);
                adapter.notifyDataSetChanged();
            }
            if(resultCode == DELETE) {
                arr.remove(index);
                adapter.notifyDataSetChanged();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

