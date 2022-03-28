package com.example.mohibrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class listhistory extends AppCompatActivity {

    private ListView historylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listhistory);

//        historylist = findViewById(R.id.historylist);
//        MyDatabasehelper databasehelper = new MyDatabasehelper(listhistory.this);
//        List<historysimple> everyone = databasehelper.get_Everyone();
//        ArrayAdapter historysimpleArrayAdapter = new ArrayAdapter<historysimple>(listhistory.this, android.R.layout.simple_list_item_1,everyone);
//        historylist.setAdapter(historysimpleArrayAdapter);

        this.setTitle("History");
        historylist = findViewById(R.id.historylist);
        MyDatabasehelper databasehelper = new MyDatabasehelper(listhistory.this);
        List<String> everyone = databasehelper.get_Everyone();
        Collections.reverse(everyone);
        int k = everyone.size();
        if ( k > 10 )
            everyone.subList(10, k).clear();
        ArrayAdapter historysimpleArrayAdapter = new ArrayAdapter<String>(listhistory.this, android.R.layout.simple_list_item_1,everyone);
        historylist.setAdapter(historysimpleArrayAdapter);

                historylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String om1 = (String) adapterView.getItemAtPosition(i);
              //  Toast.makeText(listhistory.this,  om1, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(listhistory.this, MainActivity.class);
                intent.putExtra("message1", om1);
                startActivity(intent);
            }
        });

    }
}