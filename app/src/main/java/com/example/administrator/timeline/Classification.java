package com.example.administrator.timeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Classification extends AppCompatActivity {

    private ListView menu2;
    private ArrayList<String> menulists2;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        menu2 = (ListView) findViewById(R.id.sort);
        menulists2 = new ArrayList<String>();
        menulists2.add("Life");
        menulists2.add("Holiday");
        menulists2.add("Birthday");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menulists2);
        menu2.setAdapter(adapter);
    }
}



