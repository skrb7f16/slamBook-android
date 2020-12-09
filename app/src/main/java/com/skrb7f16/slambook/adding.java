package com.skrb7f16.slambook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skrb7f16.slambook.data.MyDBHandler;
import com.skrb7f16.slambook.model.SlamBook;

public class adding extends AppCompatActivity {
    String name,nickName,age,email,hobby,firstThought,bday,phoneNo,crush,aim;
    EditText editText;
    MyDBHandler db=new MyDBHandler(adding.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void addSlam(android.view.View view){
        name=getDataFromEditText(editText,R.id.formName);
        nickName=getDataFromEditText(editText,R.id.formNickName);
        age=getDataFromEditText(editText,R.id.formAge);
        firstThought=getDataFromEditText(editText,R.id.formFirsthThought);
        bday=getDataFromEditText(editText,R.id.formBday);
        crush=getDataFromEditText(editText,R.id.formCrush);
        hobby=getDataFromEditText(editText,R.id.formHobbies);
        phoneNo=getDataFromEditText(editText,R.id.fromPhone);
        aim =getDataFromEditText(editText,R.id.formAim);
        email=getDataFromEditText(editText,R.id.formEmail);
        if(checkString()==0) {
            SlamBook slamBook = new SlamBook(nickName, name, bday, hobby, phoneNo, email, aim, firstThought, age, crush);
            db.addSlamBook(slamBook);
            nullifyFields(editText, R.id.formName);
            nullifyFields(editText, R.id.fromPhone);
            nullifyFields(editText, R.id.formEmail);
            nullifyFields(editText, R.id.formAim);
            nullifyFields(editText, R.id.formFirsthThought);
            nullifyFields(editText, R.id.formHobbies);
            nullifyFields(editText, R.id.formCrush);
            nullifyFields(editText, R.id.formNickName);
            nullifyFields(editText, R.id.formAge);
            nullifyFields(editText, R.id.formBday);
            Toast.makeText(adding.this,"Your SlamBook is saved",Toast.LENGTH_SHORT).show();
        }
        else{
            int temp=checkString();
            editText=(EditText)findViewById(temp);
            editText.setError("This field is required please give this field");
        }
    }

    public String getDataFromEditText(EditText editText,int id){
        String temp;
        editText=(EditText)findViewById(id);
        temp=editText.getText().toString();
        return temp;
    }

    public void nullifyFields(EditText editText,int id){
        editText =(EditText)findViewById(id);
        editText.setText(null);
    }

    public int checkString(){
        if(name.length()==0){
            return R.id.formName;
        }
        else if(nickName.length()==0){
            return R.id.formNickName;
        }
        else if(age.length()==0){
            return R.id.formAge;
        }
        else if(bday.length()==0){
            return R.id.formBday;
        }
        else if(firstThought.length()==0){
            return R.id.formFirsthThought;
        }
        else if(crush.length()==0){
            return R.id.formCrush;
        }
        else if(hobby.length()==0){
            return R.id.formHobbies;
        }
        else if(phoneNo.length()==0){
            return R.id.fromPhone;
        }
        else if(email.length()==0){
            return R.id.formEmail;
        }
        else if(aim.length()==0){
            return R.id.formAim;
        }

        else{
            return 0;
        }
    }
}