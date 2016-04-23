package com.example.administrator.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText et_id, et_name;
    private Button btn_test, btn_local;
    //state SQLite
    SQLiteOpenHelper helper;
    private String _id;
    private String _name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // build database and call
        helper = new Sqliteopenhelper(this);
        helper.getWritableDatabase();

        et_id = (EditText) findViewById(R.id.editText1);
        et_name = (EditText) findViewById(R.id.editText2);
        btn_test = (Button) findViewById(R.id.button1);
        btn_local = (Button) findViewById(R.id.button2);

        btn_test.setOnClickListener(new localListener());
        btn_local.setOnClickListener(new testListener());



    }

    class testListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }

    }
    //register button

    class localListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            _id = et_id.getText().toString();
            _name = et_name.getText().toString();
            if (_name.equals("") || _id.equals("")) {         Toast.makeText(getApplicationContext(), "Input password and username",Toast.LENGTH_SHORT).show();
            } else {
                sureuser(_id, _name);
            }
        }

    }

    private void sureuser(String userid, String username) {
        //operation and inquire of database
        SQLiteDatabase sdb = helper.getReadableDatabase();
        try {
            String sql = "select * from student where id=? and name=?";
            // realize name and password
            Cursor cursor = sdb.rawQuery(sql, new String[] { _id, _name });
            if (cursor.getCount() > 0) {
                Intent intent = new Intent(Login.this, DaysMatter.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", _name);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Login failed",
                        Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            sdb.close();
        } catch (SQLiteException e) {
            Toast.makeText(getApplicationContext(), "Please register",
                    Toast.LENGTH_SHORT).show();
        }
    }




}

