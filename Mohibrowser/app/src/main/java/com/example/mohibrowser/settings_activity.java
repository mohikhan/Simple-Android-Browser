package com.example.mohibrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class settings_activity extends AppCompatActivity {
 private WebView myview;

 private Switch cookieenable;
 boolean p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Settings");
        setContentView(R.layout.activity_settings);

        myview = findViewById(R.id.myview);

        cookieenable = findViewById(R.id.cookieenable);

        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        cookieenable.setChecked(sharedPreferences.getBoolean("value",true));

        cookieenable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                {
                  //  myview.getSettings().setJavaScriptEnabled(false);
                    Toast.makeText(settings_activity.this, "Cookies Disabled", Toast.LENGTH_SHORT).show();
                    CookieManager.getInstance().setAcceptCookie(false);

                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    cookieenable.setChecked(false);

                }
                else
                {
                   // myview.getSettings().setJavaScriptEnabled(true);
                    Toast.makeText(settings_activity.this, "Cookies Enabled", Toast.LENGTH_SHORT).show();
                    CookieManager.getInstance().setAcceptCookie(true);
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();


                    cookieenable.setChecked(true);
                }
            }
        });

 //       Toast.makeText(settings_activity.this, "JavaScript Disabled", Toast.LENGTH_SHORT).show();



    }
}