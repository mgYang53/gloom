package com.example.gloom;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class USERDBOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase uDB;
    private DatabaseHelper uDBHelper;
    private Context uCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(USER_DB.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+USER_DB.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public USERDBOpenHelper(Context context){
        this.uCtx = context;
    }

    public USERDBOpenHelper open() throws SQLException {
        uDBHelper = new DatabaseHelper(uCtx, DATABASE_NAME, null, DATABASE_VERSION);
        uDB = uDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        uDBHelper.onCreate(uDB);
    }

    public void close(){
        uDB.close();
    }
}
