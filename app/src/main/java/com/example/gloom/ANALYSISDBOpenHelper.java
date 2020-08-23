package com.example.gloom;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ANALYSISDBOpenHelper {
    private static final String DATABASE_NAME = "analysis.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase aDB;
    private DatabaseHelper aDBHelper;
    private Context aCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(ANALYSIS_DB.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ANALYSIS_DB.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public ANALYSISDBOpenHelper(Context context){
        this.aCtx = context;
    }

    public ANALYSISDBOpenHelper open() throws SQLException {
        aDBHelper = new DatabaseHelper(aCtx, DATABASE_NAME, null, DATABASE_VERSION);
        aDB = aDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        aDBHelper.onCreate(aDB);
    }

    public void close(){
        aDB.close();
    }
}
