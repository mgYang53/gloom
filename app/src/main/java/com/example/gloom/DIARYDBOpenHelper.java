package com.example.gloom;

import android.content.Context;
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
}
