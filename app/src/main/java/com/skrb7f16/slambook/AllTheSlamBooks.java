package com.skrb7f16.slambook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.skrb7f16.slambook.data.MyDBHandler;
import com.skrb7f16.slambook.model.SlamBook;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.widget.Toolbar;
public class AllTheSlamBooks extends AppCompatActivity {
    ListView listView;
    ArrayList<Integer>ids=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_the_slam_books);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("Your Slams");
        populate();
    }

    public void populate(){
        listView=findViewById(R.id.listview);
        MyDBHandler db=new MyDBHandler(AllTheSlamBooks.this);
        final ArrayList<String>slams=new ArrayList<>();
        List<SlamBook> slamBooks=db.getAllSlamBook();
        for (SlamBook slam:slamBooks){
            slams.add(slam.getNickName());
            ids.add(slam.getId());
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,slams);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(AllTheSlamBooks.this,slamShow.class);
                intent.putExtra("id",""+ids.get(position));
                AllTheSlamBooks.this.startActivityForResult(intent,1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Toast.makeText(this,"Deleted...",Toast.LENGTH_SHORT).show();
            populate();
        }

    }
}