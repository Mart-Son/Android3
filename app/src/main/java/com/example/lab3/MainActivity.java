package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import androidx.annotation.Nullable;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String username = "admin", pass = "hello";
    Intent open_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = findViewById(R.id.login);
        EditText passwd = findViewById(R.id.passwd);

        Button b_enter = findViewById(R.id.b_enter);

        b_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = login.getText().toString();
                String pswd = passwd.getText().toString();
                if(name.equals(username) && pass.equals(pswd))
                {
                    open_intent  = new Intent(MainActivity.this, Lists.class);
                    Toast.makeText(MainActivity.this,"Добро пожаловать!", Toast.LENGTH_LONG).show();
                    open_intent.putExtra("username",name);
                    startActivity(open_intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Неверно!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v("Вызван метод", "MainActivity.onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v("Вызван метод", "MainActivity.onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v("Вызван метод", "MainActivity.onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Вызван метод", "MainActivity.onRestart");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Вызван метод", "MainActivity.onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Вызван метод", "MainActivity.onDestroy");
    }
}