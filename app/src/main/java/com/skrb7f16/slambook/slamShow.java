package com.skrb7f16.slambook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.skrb7f16.slambook.data.MyDBHandler;
import com.skrb7f16.slambook.model.SlamBook;

public class slamShow extends AppCompatActivity {
    int idOfSlam;
    TextView name,nickName,age,email,hobby,firstThought,bday,phoneNo,crush,aim;
    MyDBHandler db=new MyDBHandler(slamShow.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slam_show);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        idOfSlam=Integer.parseInt(id);
        SlamBook slamBook=db.getSlamBook(idOfSlam);
        setThings(name,R.id.nameValue,slamBook.getName());
        setThings(nickName,R.id.nickNameValue,slamBook.getNickName());
        setThings(age,R.id.ageValue,slamBook.getAge());
        setThings(email,R.id.emailValue,slamBook.getEmail());
        setThings(bday,R.id.bdayValue,slamBook.getBday());
        setThings(crush,R.id.crushValue,slamBook.getCrush());
        setThings(phoneNo,R.id.phoneValue,slamBook.getPhoneNo());
        setThings(firstThought,R.id.firstThoughtValue,slamBook.getFirstThought());
        setThings(aim,R.id.aimValue,slamBook.getAim());
        setThings(hobby,R.id.hobbyValue,slamBook.getHobby());
    }

    public void setThings(TextView textView,int idOfView,String value){
        textView=(TextView) findViewById(idOfView);
        textView.setText(value);
    }

    public void deleteSlam(View view){
        AlertDialog diaBox = AskOption();
        diaBox.show();
    }


    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                // set message, title, and icon
                .setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        db.deleteSlamBook(idOfSlam);
                        finish();
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;
    }
}