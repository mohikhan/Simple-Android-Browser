package com.example.mohibrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mybar;
    private WebView myview;

   private EditText editurl;
   private Button editbtn;
   private Button bkmrk ;
 // public Switch javaenable;
   private Button accessme;
   private Button accesshist;
   private ListView bkmarks22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myview = findViewById(R.id.myview);

        mybar = findViewById(R.id.mybar);
        editurl = findViewById(R.id.editurl);
        editbtn = findViewById(R.id.gotobtn);
     //   bkmrk = findViewById(R.id.bkmrk);
     //   accessme = findViewById(R.id.Accessb);
       // accesshist = findViewById(R.id.Accesshist);
       // bkmarks22 = findViewById(R.id.bkmarks22);
    //    javaenable = findViewById(R.id.cookieenable);

         Intent intent = getIntent();
        mybar.setMax(100);
        myview.loadUrl("https://www.google.com");
        myview.setWebViewClient(new WebViewClient());
        myview.getSettings().setLoadsImagesAutomatically(true);
       myview.getSettings().setJavaScriptEnabled(true);

       int[] cdn = {1};

//       if(isNetworkAvailable())
//       { Toast.makeText(MainActivity.this, "Connected to Internet" , Toast.LENGTH_SHORT).show();}
//       else
//       {Toast.makeText(MainActivity.this, "Not Connected to Internet" , Toast.LENGTH_SHORT).show();}





//        javaenable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(!b)
//                {myview.getSettings().setJavaScriptEnabled(false);}
//                else
//                {
//                    myview.getSettings().setJavaScriptEnabled(true);
//                }
//            }
//        });
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String irl = editurl.getText().toString();

                if(irl.contains("https://") || irl.contains("www.") || irl.contains("http://") || irl.contains(".com"))
                {
                    if(irl.contains("https://") || irl.contains("http://"))
                    {
                        myview.loadUrl(irl);
                    }
                    else

                    {
                        myview.loadUrl("https://"+ irl);
                    }

                }
                else
                {
                    myview.loadUrl("https://google.com/search?q=" + irl);
                }
                //   myview.setWebViewClient(new WebViewClient());
                //   myview.getSettings().setLoadsImagesAutomatically(true);
                //    myview.getSettings().setJavaScriptEnabled(true);
                //     myview.loadUrl(irl);
             //   myview.setWebViewClient(new WebViewClient());
             //   myview.getSettings().setLoadsImagesAutomatically(true);
            //    myview.getSettings().setJavaScriptEnabled(true);
             //   myview.loadUrl(irl);

            }
        });




        myview.setWebChromeClient(new WebChromeClient()
          {
                                      @Override
                                       public void onProgressChanged(WebView view, int newProgress) {
                                          super.onProgressChanged(view, newProgress);
                                          mybar.setVisibility(view.VISIBLE);
                                          mybar.setProgress(newProgress);
                                          if(newProgress == 100)
                                          {
                                              mybar.setVisibility(view.GONE);
                                          }
//                                          if(newProgress == 100) {
//
//                                         //     mybar.setVisibility(view.GONE);
//                                              String histUrl = myview.getUrl();
//                                              historysimple hm;
//
//
//                                              hm = new historysimple(1, histUrl);
//                                              MyDatabasehelper histdbhelper = new MyDatabasehelper(MainActivity.this);
//                                              boolean success2 = histdbhelper.add_One(hm);
//
//                                          }
                                      }

                                      @Override
                                      public void onReceivedTitle(WebView view, String title) {
                                          super.onReceivedTitle(view, title);
                                          getSupportActionBar().setTitle(title);

                                          String histUrl = myview.getUrl();
                                          historysimple hm;
                                     //     mybar.setVisibility(view.GONE);


                                          hm = new historysimple(1, histUrl);
                                          MyDatabasehelper histdbhelper = new MyDatabasehelper(MainActivity.this);
                                          boolean success2 = histdbhelper.add_One(hm);
                                    //      Toast.makeText(MainActivity.this, "Called ", Toast.LENGTH_SHORT).show();
                                      }






                                  }

        );

        String str = intent.getStringExtra("message1");
        String str2 = intent.getStringExtra("message");

        final Handler ha=new Handler();
        if(str != null){
        myview.loadUrl(str);
      //  str = null;

       // Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

        }
        else if(str2 != null){
            myview.loadUrl(str2);
            //  str = null;

            // Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

        }
        else
        { //str =null;
           // Toast.makeText(MainActivity.this, "Success bro", Toast.LENGTH_SHORT).show();

            ha.postDelayed(new Runnable() {

                @Override
                public void run() {
                    if(cdn[0] == 1){
                        if (isNetworkAvailable()) {
                            //     variableclass.dani = 0;
                            //     variableclass.setDani(0);
                            cdn[0] = 0;
                            Toast.makeText(MainActivity.this, "Connected to Internet", Toast.LENGTH_SHORT).show();

                        } }

                    else if(cdn[0] == 0) {
                        if (!isNetworkAvailable()) {
                            Toast.makeText(MainActivity.this, "Not Connected to Internet", Toast.LENGTH_SHORT).show();
                            cdn[0] = 1;
                            //         variableclass.dani = 1;
                            //        variableclass.setDani(1);
                        }
                    }



                    //   Toast.makeText(MainActivity.this, "YO YO" , Toast.LENGTH_SHORT).show();
                    ha.postDelayed(this, 2000);
                }
            }, 2000);
        }
        myview.loadUrl(str2);



//        bkmrk.setOnClickListener(
//                new View.OnClickListener() {
//
//
//                    @Override
//                    public void onClick(View view) {
//                        bkmarksimple bm;
//
//                     //   historysimple hm;
//
//                        try {
//                            String webUrl = myview.getUrl();
//                            bm = new bkmarksimple(1,  webUrl);
//                   //         hm = new historysimple(1,webUrl);
//                     //       Toast.makeText(MainActivity.this, bm.toString(), Toast.LENGTH_SHORT).show();
//                   //         Toast.makeText(MainActivity.this, hm.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                        catch (Exception e)
//                        {
//                            Toast.makeText(MainActivity.this, "Error creating customer",Toast.LENGTH_SHORT).show();
//                            bm = new bkmarksimple(-1, "error");
//                   //         hm = new historysimple(-1, "error");
//                        }
//
//                        Databasehelper databasehelper = new Databasehelper(MainActivity.this);
//                 //       MyDatabasehelper histdbhelper = new MyDatabasehelper(MainActivity.this);
//                        boolean success = databasehelper.addOne(bm);
//               //         boolean success2 = histdbhelper.add_One(hm);
//                  //      Toast.makeText(MainActivity.this, "Result : " + success, Toast.LENGTH_SHORT).show();
//                    //    Toast.makeText(MainActivity.this, "Result : " + success2, Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );




//        accessme.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        //Open new activity
//
//                    openbookmarks();
//
////                   // Main code commented
////                  Databasehelper databasehelper = new Databasehelper(MainActivity.this);
////                        List<bkmarksimple> everyone = databasehelper.getEveryone();
////                        ArrayAdapter bmarkarrayadapter = new ArrayAdapter<bkmarksimple>(MainActivity.this, android.R.layout.simple_list_item_1,everyone);
////                        bkmarks22.setAdapter(bmarkarrayadapter);
//
//                    }
//                }
//        );

//        accesshist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openhistory();
//            }
//        });
    }

    public void openbookmarks()
    {
        Intent intent = new Intent(this, listbmarks.class);
        startActivity(intent);

    }

    public void openhistory()
    {
        Intent intent = new Intent(this, listhistory.class);
        startActivity(intent);
    }
//    public boolean isNetworkAvailable() {
//        // Get Connectivity Manager class object from Systems Service
//        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        // Get Network Info from connectivity Manager
//        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
//
//        // if no network is available networkInfo will be null
//        // otherwise check if we are connected
//        if (networkInfo != null && networkInfo.isConnected()) {
//
//            return true;
//        }
//        return false;
//    }

    public void opensettings()
    {
        Intent intent = new Intent(this, settings_activity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean isNetworkAvailable() {
        // Get Connectivity Manager class object from Systems Service
        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get Network Info from connectivity Manager
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {

            return true;
        }
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_back:
                onBackPressed();
                break;
            case R.id.menu_frwrd:
                Onforward();
                break;
            case R.id.accessbookmarks:
                openbookmarks();
                break;
            case R.id.accesshistory:
                openhistory();
                break;
            case R.id.settingsme:
                opensettings();
                break;
            case R.id.refreshme:
                myview.reload();
                break;
            case R.id.makebkmrk:
                bkmarksimple bm;
                myview = findViewById(R.id.myview);
                //   historysimple hm;

                String webUrl = myview.getUrl();
                bm = new bkmarksimple(1,  webUrl);

                Databasehelper databasehelper = new Databasehelper(MainActivity.this);
                boolean success = databasehelper.addOne(bm);
                Toast.makeText(MainActivity.this, "Page Bookmarked" , Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    private void Onforward()
    {
        if(myview.canGoForward())
        {

            myview.goForward();
        }

            else{
        Toast.makeText(this, "Can't go forward", Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    public void onBackPressed() {
        if(myview.canGoBack())
        {
            myview.goBack();
        }
        else
        {finish();}
    }

//
//    public class WebViewClient extends android.webkit.WebViewClient {
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(myview, );
//            mybar.setVisibility(View.GONE);
//        }
//    }


}