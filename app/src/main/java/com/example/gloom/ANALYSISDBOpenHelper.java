package com.example.gloom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public long insertColumn(String date, int result, int useridx){
        ContentValues values = new ContentValues();
        values.put(ANALYSIS_DB.CreateDB.DATE, date);
        values.put(ANALYSIS_DB.CreateDB.RESULT, result);
        values.put(ANALYSIS_DB.CreateDB.USER_IDX, useridx);
        return aDB.insert(ANALYSIS_DB.CreateDB._TABLENAME0, null, values);
    }

    public Cursor selectColumns(){
        return aDB.query(ANALYSIS_DB.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    public Cursor sortColumn(String sort){
        Cursor c = aDB.rawQuery( "SELECT * FROM analysistable ORDER BY " + sort + ";", null);
        return c;
    }

    public boolean updateResult(int useridx, int result){
        ContentValues values = new ContentValues();
        values.put(ANALYSIS_DB.CreateDB.RESULT, result);
        return aDB.update(ANALYSIS_DB.CreateDB._TABLENAME0, values, "user_idx=" + useridx, null) > 0;
    }
}
