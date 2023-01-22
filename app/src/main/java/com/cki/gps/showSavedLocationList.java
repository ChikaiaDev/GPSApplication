package com.cki.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class showSavedLocationList extends AppCompatActivity {

    ListView lv_savedLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_location_list);

        //give values to variables
        lv_savedLocations = findViewById(R.id.lv_savedLocations);

        MyApplication myApplication= (MyApplication) getApplicationContext();
        List<Location> savedLocations = myApplication.getMyLocations();

        lv_savedLocations.setAdapter(new ArrayAdapter<>(this, android.R.layout.activity_list_item, savedLocations));
    }
}