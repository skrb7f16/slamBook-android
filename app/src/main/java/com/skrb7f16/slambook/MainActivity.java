package com.skrb7f16.slambook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.skrb7f16.slambook.data.MyDBHandler;
import com.skrb7f16.slambook.model.SlamBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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