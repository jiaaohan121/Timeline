package com.example.administrator.timeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Adding extends AppCompatActivity {
    private ListView menu1;
    private ArrayList<String> menulists1;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        menu1 = (ListView) findViewById(R.id.add);
        menulists1 = new ArrayList<String>();
        menulists1.add("Topic");
        menulists1.add("Date");
        menulists1.add("Classification");
        menulists1.add("Repetition");
        menulists1.add("Clock");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menulists1);
        menu1.setAdapter(adapter);
    }
}





