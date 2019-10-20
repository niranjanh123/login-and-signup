package com.example.coffee;

        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class login_form extends AppCompatActivity {
    SQLiteOpenHelper sqLiteOpenHelper;
    DatabaseHelper mydb;
    SQLiteDatabase db;
    Cursor cursor;
    EditText edit_Email, edit_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login");
        Button b1 = (Button) findViewById(R.id.login_button);
        sqLiteOpenHelper = new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = sqLiteOpenHelper.getReadableDatabase();
                edit_Email = (EditText) findViewById(R.id.login_email);
                edit_Password = (EditText) findViewById(R.id.login_password);
                String ema = edit_Email.getText().toString();
                String pass = edit_Password.getText().toString();
                if(ema.matches("")||pass.matches(""))
                {
                  Toast.makeText(getApplicationContext(),"Please enter the details properly",Toast.LENGTH_LONG).show();
                  return;
                }

                cursor = db.rawQuery("select *  from " + DatabaseHelper.TABLE_NAME + " where " + DatabaseHelper.COL_3 + " = ? AND "+
                        DatabaseHelper.COL_4 + "=?", new String[]{ema, pass});
                if(cursor!=null)
                {
                    if(cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(login_form.this,items_page.class);
                        startActivity(intent);
                        finish();
                    }else
                        if(cursor.getCount()==0)
                    {
                        Toast.makeText(getApplicationContext(),"Login Unsuccessfull",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

}
