package com.example.todoapp;

import android.content.Context;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ListView;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;

    private ArrayAdapter<String>itemsAdapter;

    private ListView listView;

    private Button button;

    private EditText editTextInput;





    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.listView);

        button = findViewById(R.id.button);

        editTextInput = findViewById(R.id.editTextInput);



        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                addItem(view);





            }

        });

        items = new ArrayList<>();

        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);

        listView.setAdapter(itemsAdapter);

        SetupListViewListner();

    }



    private boolean SetupListViewListner() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int item , long i) {

                Context context = getApplicationContext();

                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

                items.remove(i);

                itemsAdapter.notifyDataSetChanged();

                return true;



            }

        });

        Context context = getApplicationContext();

        Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

        items.remove(items);

        itemsAdapter.notifyDataSetChanged();

        return true;



    }



    private void addItem(View view) {

        editTextInput  = findViewById(R.id.editTextInput);

        String itemText = editTextInput.getText().toString();

        if (!(itemText.equals(""))){

            itemsAdapter.add(itemText);

            editTextInput.setText("");

        }

        else {

            Toast.makeText(getApplicationContext(),"Please Enter Text",Toast.LENGTH_LONG).show();

        }





    }






}