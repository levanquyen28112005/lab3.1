package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab3.R;

public class Demo31MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31_main);
        btn1=findViewById(R.id.demo31Btn1);
        btn2=findViewById(R.id.demo31Btn2);
        btn3=findViewById(R.id.demo31Btn3);
        btn4=findViewById(R.id.demo31Btn4);
        //1. Alert Dialog
        btn1.setOnClickListener(v->{
            //1.1 Tao builder
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            //1.2. Them cac thanh phan cho builder
            builder.setTitle("Thong bao");
            builder.setMessage("noi dung can thong bao");
            //1.3. Them button ok,cancel
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Ban dong y",
                            Toast.LENGTH_LONG).show();
                }
            });
            //cancel
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Ban da cancel",
                            Toast.LENGTH_LONG).show();
                }
            });
            //b1.4 tao dialog dua tren builder
            AlertDialog alertDialog=builder.create();
            //1.5. Hien thi dia log
            alertDialog.show();
        });
        //---------
        //Single Choice
        btn2.setOnClickListener(v->{
            //B1.lay nguon du lieu
            String[] arr={"Xanh","Do","Tim","Vang"};
            //B2. Tao builder
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            //b3. Tao cac thanh phan cho builder
            builder.setTitle("Tieu de");
            //b4. Set single choice cho alert
            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Ban chon: "+arr[which],Toast.LENGTH_LONG).show();
                }
            });
            //b5.Tao dialog tu builder
            AlertDialog alertDialog=builder.create();
            //b6. Hien thi builder
            alertDialog.show();
        });
        //Multiple choice
        btn3.setOnClickListener(v->{
            //B1.lay nguon du lieu
            String[] arr={"Xanh","Do","Tim","Vang"};
            //B2. Tao builder
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            //b3. Tao cac thanh phan cho builder
            builder.setTitle("Tieu de");
            //b4. Set multiple choice cho alert
            builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Toast.makeText(getApplicationContext(),"Ban chon: "+arr[which],Toast.LENGTH_SHORT).show();
                }
            });
            //b5.Tao dialog tu builder
            AlertDialog alertDialog=builder.create();
            //b6. Hien thi builder
            alertDialog.show();
        });
        //Dang nhap bang dialog
        btn4.setOnClickListener(v->{
            //B1. Tao builder
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            //b2. Gan layout
            LayoutInflater inflater=getLayoutInflater();
            View view1=inflater.inflate(R.layout.demo31_login_form,null);
            builder.setView(view1);//dua view vao builder
            //anh xa cac thanh phan
            final EditText txtUser=(EditText) view1.findViewById(R.id.demo31_login_form_txtU);
            final EditText txtPass=(EditText) view1.findViewById(R.id.demo31_login_form_txtP);
            //b4. Them cac thanh phan khac cho form: title, ok, cancel
            builder.setTitle("Login form");
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),
                            "Xin chao "+txtUser.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),
                            "Logout",Toast.LENGTH_LONG).show();
                }
            });
            //B5. Tao dialog tu builder
            AlertDialog alertDialog=builder.create();
            //b6. Hien thi dialog
            alertDialog.show();
        });
    }
}