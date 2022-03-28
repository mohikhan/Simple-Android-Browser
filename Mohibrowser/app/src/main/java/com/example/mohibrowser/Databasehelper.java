package com.example.mohibrowser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Databasehelper extends SQLiteOpenHelper {

    //for bookmarks

    public static final String BMARKS_TABLE = "BMARKS_TABLE";
    public static final String COLUMN_URL_NAME = "URL_NAME";
    public static final String COLUMN_ID = "ID";

    public Databasehelper(@Nullable Context context) {
        super(context, "Bkmarks.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry = "CREATE TABLE " + BMARKS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_URL_NAME + " TEXT)";

                db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(bkmarksimple Bkmarksimple){
      SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_URL_NAME, Bkmarksimple.getUrlname() );
        long insert = db.insert(BMARKS_TABLE, null, cv);

        if(insert == -1)
        {return false;}
        else{
        return true;}
    }

//    public List<bkmarksimple> getEveryone()
//    {
//        List<bkmarksimple> returnList = new ArrayList<>();
//         String querystring = "SELECT * FROM " + BMARKS_TABLE;
//       // String querystring = "SELECT " + COLUMN_URL_NAME + " FROM " + BMARKS_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery(querystring,null);
//
//
//        if(cursor.moveToFirst())
//        {
//            do{
//                int bmarkid = cursor.getInt(0);
//                String bmarkurl = cursor.getString(1);
//           //     bkmarksimple obj = new bkmarksimple(bmarkid,bmarkurl);
//                bkmarksimple obj = new bkmarksimple(bmarkurl);
//                returnList.add(obj);
//            }
//            while (cursor.moveToNext());
//
//        }
//        else
//        {}
//        cursor.close();
//        db.close();
//    return returnList;
//    }

    public List<String> getEveryone()
    {
        List<String> returnList = new ArrayList<>();
        String querystring = "SELECT * FROM " + BMARKS_TABLE;
        // String querystring = "SELECT " + COLUMN_URL_NAME + " FROM " + BMARKS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(querystring,null);


        if(cursor.moveToFirst())
        {
            do{
                //int bmarkid = cursor.getInt(0);
                String bmarkurl = cursor.getString(1);
                //     bkmarksimple obj = new bkmarksimple(bmarkid,bmarkurl);
               // bkmarksimple obj = new bkmarksimple(bmarkurl);
                returnList.add(bmarkurl);
            }
            while (cursor.moveToNext());

        }
        else
        {}
        cursor.close();
        db.close();
        return returnList;
    }



}
