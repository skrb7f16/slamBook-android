package com.skrb7f16.slambook.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;


import com.skrb7f16.slambook.model.SlamBook;
import com.skrb7f16.slambook.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    public  MyDBHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="create table "+Params.TABLE_NAME+"("
                +Params.KEY_ID+" integer primary key, "+Params.KEY_NAME+" text, "+Params.KEY_NICKNAME+" text, "
                +Params.KEY_EMAIL+" text, "+Params.KEY_PHONENO+" text, "+Params.KEY_AGE+" text, "+Params.KEY_BDAY+" text, "+Params.KEY_CRUSH+" text, "
                +Params.KEY_FIRST_THOUGHT+" text, "+Params.KEY_HOBBY+" text, "+Params.KEY_AIM+" text "+")";
        Log.d("skrb7f16db",create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addSlamBook(SlamBook slamBook){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,slamBook.getName());
        values.put(Params.KEY_NICKNAME,slamBook.getNickName());
        values.put(Params.KEY_EMAIL,slamBook.getEmail());
        values.put(Params.KEY_PHONENO,slamBook.getPhoneNo());
        values.put(Params.KEY_AGE,slamBook.getAge());
        values.put(Params.KEY_BDAY,slamBook.getBday());
        values.put(Params.KEY_CRUSH,slamBook.getCrush());
        values.put(Params.KEY_FIRST_THOUGHT,slamBook.getFirstThought());
        values.put(Params.KEY_HOBBY,slamBook.getHobby());
        values.put(Params.KEY_AIM,slamBook.getAim());
        db.insert(Params.TABLE_NAME,null,values);
        db.close();
        Log.d("skrb7f16db","success");
    }

    public List<SlamBook> getAllSlamBook(){
        List<SlamBook> slamBooks=new ArrayList<SlamBook>();
        SQLiteDatabase db=this.getReadableDatabase();
        //generating query to read
        String select="select * from "+Params.TABLE_NAME;
        Cursor cursor =db.rawQuery(select,null);
        // loop through
        if (cursor.moveToFirst()){
            do {
                SlamBook slamBook=new SlamBook();
                slamBook.setId(Integer.parseInt(cursor.getString(0)));
                slamBook.setName(cursor.getString(1));
                slamBook.setNickName(cursor.getString(2));
                slamBook.setEmail(cursor.getString(3));
                slamBook.setPhoneNo(cursor.getString(4));
                slamBook.setAge(cursor.getString(5));
                slamBook.setBday(cursor.getString(6));
                slamBook.setCrush(cursor.getString(7));
                slamBook.setFirstThought(cursor.getString(8));
                slamBook.setHobby(cursor.getString(9));
                slamBook.setAim(cursor.getString(10));
                slamBooks.add(slamBook);
            }while (cursor.moveToNext());
        }
        db.close();
        return slamBooks;
    }

    public int updateSlamBook(SlamBook slamBook){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,slamBook.getName());
        values.put(Params.KEY_NICKNAME,slamBook.getNickName());
        values.put(Params.KEY_EMAIL,slamBook.getEmail());
        values.put(Params.KEY_PHONENO,slamBook.getPhoneNo());
        values.put(Params.KEY_AGE,slamBook.getAge());
        values.put(Params.KEY_BDAY,slamBook.getBday());
        values.put(Params.KEY_CRUSH,slamBook.getCrush());
        values.put(Params.KEY_FIRST_THOUGHT,slamBook.getFirstThought());
        values.put(Params.KEY_HOBBY,slamBook.getHobby());
        values.put(Params.KEY_AIM,slamBook.getAim());
        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{String.valueOf(slamBook.getId())});
    }

    public void deleteSlamBook(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String []{String.valueOf(id)});
        db.close();
    }
    public void deleteSlamBook(SlamBook slamBook){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String []{String.valueOf(slamBook.getId())});
        db.close();
    }

    public SlamBook getSlamBook(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        SlamBook slamBook=new SlamBook();
        String query="select * from "+Params.TABLE_NAME+" where "+Params.KEY_ID+" = "+id;
        Cursor cursor =db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            slamBook.setId(Integer.parseInt(cursor.getString(0)));
            slamBook.setName(cursor.getString(1));
            slamBook.setNickName(cursor.getString(2));
            slamBook.setEmail(cursor.getString(3));
            slamBook.setPhoneNo(cursor.getString(4));
            slamBook.setAge(cursor.getString(5));
            slamBook.setBday(cursor.getString(6));
            slamBook.setCrush(cursor.getString(7));
            slamBook.setFirstThought(cursor.getString(8));
            slamBook.setHobby(cursor.getString(9));
            slamBook.setAim(cursor.getString(10));
        }
        db.close();
        return slamBook;
    }




}
