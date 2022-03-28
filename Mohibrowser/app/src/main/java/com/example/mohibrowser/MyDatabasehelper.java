package com.example.mohibrowser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabasehelper extends SQLiteOpenHelper {

    public static final String HISTORY_TABLE = "HISTORY_TABLE";
    public static final String COLUMN_HISTORY_URL = "HISTORY_URL";
    public static final String COLUMN_ID = "ID";

    public MyDatabasehelper(@Nullable Context context) {
        super(context, "History.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry1 = "CREATE TABLE " + HISTORY_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HISTORY_URL + " TEXT)";
        db.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean add_One(historysimple Historysimple){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HISTORY_URL, Historysimple.getHistoryname());
        long insert = db.insert(HISTORY_TABLE, null, cv);

        if(insert == -1)
        {return false;}
        else{
            return true;}
    }

//    public List<historysimple> get_Everyone()
//    {
//        List<historysimple> returnList = new ArrayList<>();
//        String querystring = "SELECT * FROM " + HISTORY_TABLE;
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
//                historysimple obj = new historysimple(bmarkid,bmarkurl);
//                returnList.add(obj);
//            }
//            while (cursor.moveToNext());
//
//        }
//        else
//        {}
//        cursor.close();
//        db.close();
//        return returnList;
//    }


    public List<String> get_Everyone()
    {
        List<String> returnList = new ArrayList<>();
        String querystring = "SELECT * FROM " + HISTORY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(querystring,null);


        if(cursor.moveToFirst())
        {
            do{
            //    int bmarkid = cursor.getInt(0);
                String bmarkurl = cursor.getString(1);
              //  historysimple obj = new historysimple(bmarkid,bmarkurl);
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
