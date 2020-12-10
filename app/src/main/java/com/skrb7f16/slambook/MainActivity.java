package com.skrb7f16.slambook;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.skrb7f16.slambook.data.MyDBHandler;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDBHandler db=new MyDBHandler(MainActivity.this);
    }



    public void addNew(android.view.View view){
        Intent intent=new Intent(MainActivity.this,adding.class);
        startActivity(intent);
    }
    public void viewPrevious(android.view.View view){
        Intent intent=new Intent(MainActivity.this,AllTheSlamBooks.class);
        startActivity(intent);
    }
}