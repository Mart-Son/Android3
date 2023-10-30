package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.SimpleAdapter;

public class Lists extends AppCompatActivity {
    ArrayList<String> stringArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        ListView listView = findViewById(R.id.listik);
        Button B_Add = findViewById(R.id.add);
        Button B_Delete = findViewById(R.id.delete);
        EditText entry = findViewById(R.id.edit_1);

        Log.d("Вызван метод: ", "onCreate");

        Bundle args = getIntent().getExtras();
        String name = args.get("username").toString();

        ArrayAdapter<String> TxtAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_multiple_choice,stringArray);

        ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_multiple_choice,stringArray);

        listView.setAdapter(TxtAdapter);
        listView.setAdapter(Adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SparseBooleanArray selected = listView.getCheckedItemPositions();

                B_Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for(int i=stringArray.size();i>=0;i--)
                        {
                            if(selected.get(i))
                            {
                                stringArray.remove(i);
                            }
                        }
                        listView.setAdapter(TxtAdapter);
                        listView.setAdapter(Adapter2);
                    }
                });
            }
        });

        B_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = entry.getText().toString();
                if(!res.isEmpty())
                {
                    stringArray.add(res);
                    listView.setAdapter(TxtAdapter);
                    listView.setAdapter(Adapter2);
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v("Вызван метод", "Lists.onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v("Вызван метод", "Lists.onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v("Вызван метод", "Lists.onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Вызван метод", "Lists.onRestart");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Вызван метод", "Lists.onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Вызван метод", "Lists.onDestroy");
    }
}