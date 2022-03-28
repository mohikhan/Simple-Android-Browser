package com.example.mohibrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class listbmarks extends AppCompatActivity {

    private ListView bmarkslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbmarks);

//        bmarkslist = findViewById(R.id.bkmarkslist);
//        Databasehelper databasehelper = new Databasehelper(listbmarks.this);
//        List<bkmarksimple> everyone = databasehelper.getEveryone();
//        ArrayAdapter bmarkarrayadapter = new ArrayAdapter<bkmarksimple>(listbmarks.this, android.R.layout.simple_list_item_1,everyone);
//        bmarkslist.setAdapter(bmarkarrayadapter);
        this.setTitle("Bookmarks");
        bmarkslist = findViewById(R.id.bkmarkslist);
        Databasehelper databasehelper = new Databasehelper(listbmarks.this);
        List<String> everyone = databasehelper.getEveryone();
        ArrayAdapter<String> bmarkarrayadapter = new ArrayAdapter<String>(listbmarks.this, android.R.layout.simple_list_item_1, everyone);
        bmarkslist.setAdapter(bmarkarrayadapter);

                bmarkslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String om = (String) adapterView.getItemAtPosition(i);
              //  Toast.makeText(listbmarks.this,  om, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(listbmarks.this, MainActivity.class);
                intent.putExtra("message", om);
             //   intent.putExtra("netvalue","zero");
                startActivity(intent);
                //openselected();
             //   p1.myview.loadUrl(om);
            }
        });

    }
}