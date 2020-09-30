package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    View mainLayout;
    EditText editColor;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("TAG", "onCreate");

        mainLayout = findViewById(R.id.layout_main);
        editColor = findViewById(R.id.edt_color);

        if (savedInstanceState == null)
            i = 0;
        else
            i = savedInstanceState.getInt("index");

        findViewById(R.id.btn_increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Log.v("TAG", "i = " + i);
            }
        });

        editColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                if (str.equals("red"))
                    mainLayout.setBackgroundColor(0xFFFF0000);
                else if (str.equals("green"))
                    mainLayout.setBackgroundColor(0xFF00FF00);
                else if (str.equals("blue"))
                    mainLayout.setBackgroundColor(0xFF0000FF);
                else
                    mainLayout.setBackgroundColor(0xFFFFFFFF);
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("TAG", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v("TAG", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("TAG", "onResume");
//        SharedPreferences pref = getSharedPreferences("color", 0);
//        String str = pref.getString("color", "");
//        editColor.setText(str);
//        Log.v("TAG", "Saved color: " + str);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("TAG", "onPause");
//        SharedPreferences pref = getSharedPreferences("color", 0);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("color", editColor.getText().toString());
//        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("TAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("index", i);
        super.onSaveInstanceState(outState);
    }

}