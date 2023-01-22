package com.cki.gps;

import android.database.DataSetObserver;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class showSavedLocation extends AppCompatActivity {

    ListView lv_savedLocations;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_location);

        //give values to variables
//        lv_savedLocations = findViewById(R.id.lv_savedLocations);

        MyApplication myApplication= (MyApplication) getApplicationContext();
        List<Location> savedLocations = myApplication.getMyLocations();

        expandableListAdapter = new MyExpandableListAdapter(this, savedLocations);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandablePosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if( lastExpandablePosition != -1 && i != lastExpandablePosition){
                    expandableListView.collapseGroup(lastExpandablePosition);
                }
                lastExpandablePosition = i;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(myApplication, "Selected :" +expandableListAdapter.getChild(i,i1).toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}