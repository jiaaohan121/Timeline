package com.example.administrator.timeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class AddTask extends AppCompatActivity {
    private ListView menu3;
    private ArrayList<String> menulists3;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        menu3 = (ListView) findViewById(R.id.task);
        menulists3 = new ArrayList<String>();
        menulists3.add("Task");
        menulists3.add("Time interval");
        menulists3.add("Bell");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menulists3);
        menu3.setAdapter(adapter);
    }
}



