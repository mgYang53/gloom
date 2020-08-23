package com.example.gloom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DIARYDBOpenHelper {
    private static final String DATABASE_NAME = "diary.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase dDB;
    private DatabaseHelper dDBHelper;
    private Context dCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DIARY_DB.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+DIARY_DB.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public DIARYDBOpenHelper(Context context){
        this.dCtx = context;
    }

    public DIARYDBOpenHelper open() throws SQLException {
        dDBHelper = new DatabaseHelper(dCtx, DATABASE_NAME, null, DATABASE_VERSION);
        dDB = dDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        dDBHelper.onCreate(dDB);
    }

    public void close(){
        dDB.close();
    }

    public long insertColumn(String date, String content, int useridx){
        ContentValues values = new ContentValues();
        values.put(DIARY_DB.CreateDB.DATE, date);
        values.put(DIARY_DB.CreateDB.CONTENT, content);
        values.put(DIARY_DB.CreateDB.USER_IDX, useridx);
        return dDB.insert(DIARY_DB.CreateDB._TABLENAME0, null, values);
    }

    public Cursor selectColumns(){
        return dDB.query(DIARY_DB.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    public Cursor sortColumn(String sort){
        Cursor c = dDB.rawQuery( "SELECT * FROM diarytable ORDER BY " + sort + ";", null);
        return c;
    }
}
