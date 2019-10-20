package com.example.coffee;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.coffee.DatabaseHelper.COL_1;
import static com.example.coffee.DatabaseHelper.COL_2;
import static com.example.coffee.DatabaseHelper.COL_3;
import static com.example.coffee.DatabaseHelper.COL_4;

public class sign_up extends AppCompatActivity {
    SQLiteOpenHelper sqLiteOpenHelper;
    DatabaseHelper mydb=new DatabaseHelper(this);
    EditText edit_FullName, edit_Username, edit_Email, edit_Password;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign Up");
        edit_FullName = (EditText) findViewById(R.id.fullname);
        edit_Username = (EditText) findViewById(R.id.username);
        edit_Email = (EditText) findViewById(R.id.email);
        edit_Password = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.signup);
        sqLiteOpenHelper = new DatabaseHelper(this);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteOpenHelper.getWritableDatabase();
                String fullname = edit_FullName.getText().toString();
                String username = edit_Username.getText().toString();
                String email = edit_Email.getText().toString();
                String password = edit_Password.getText().toString();
                if(fullname.matches("")||username.matches("")||email.matches("")||password.matches("")){
                    Toast.makeText(sign_up.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
                }
                else
                    {
                    add_data(fullname, username, email, password);
                }
            }
        });
    }

    public boolean add_data(String full,String user,String em,String pass)
    {
       boolean res= mydb.insertData(full,user,em,pass);
       if(res==true){
           Toast.makeText(sign_up.this,"SignUp successfull",Toast.LENGTH_LONG).show();
           Intent intent= new Intent(sign_up.this,login_form.class);
           startActivity(intent);
           finish();
           return true;
       }
       else
           Toast.makeText(sign_up.this,"SignUp again with different credentials",Toast.LENGTH_LONG).show();
           return false;
    }


}
