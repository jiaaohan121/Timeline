package com.example.administrator.timeline;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class DaysMatter extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;
    private ListView infor;
    private ArrayList<String> inforList;
    private ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_matter);
        findViewById(R.id.add1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaysMatter.this, Adding.class));
            }
        });
        findViewById(R.id.classi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaysMatter.this, Classification.class));
            }
        });
        infor = (ListView) findViewById(R.id.listView);
        inforList = new ArrayList<String>();
        inforList.add("Weekend                                         1day");
        inforList.add("Holiday                                       10days");
        inforList.add("Birthday                                     100days");
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inforList);
        infor.setAdapter(adapter1);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mDrawerList = (ListView) findViewById(R.id.message);
        menuLists = new ArrayList<String>();
        menuLists.add("All");
        menuLists.add("Life");
        menuLists.add("Festival");
        menuLists.add("Birthday");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuLists);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // insert fragment
                Fragment contentFragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", menuLists.get(position));
                contentFragment.setArguments(args);

                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.id_framelayout, contentFragment).commit();

                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });


    }
}