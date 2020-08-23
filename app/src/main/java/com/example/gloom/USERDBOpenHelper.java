package com.example.gloom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public long insertColumn(String userid, String userpw, String tel , String email){
        ContentValues values = new ContentValues();
        values.put(USER_DB.CreateDB.USERID, userid);
        values.put(USER_DB.CreateDB.USERPW, userpw);
        values.put(USER_DB.CreateDB.TEL, tel);
        values.put(USER_DB.CreateDB.EMAIL, email);
        return uDB.insert(USER_DB.CreateDB._TABLENAME0, null, values);
    }

    public Cursor selectColumns(){
        return uDB.query(USER_DB.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    public Cursor sortColumn(String sort){
        Cursor c = uDB.rawQuery( "SELECT * FROM usertable ORDER BY " + sort + ";", null);
        return c;
    }

    public boolean updatePW(String userid, String userpw){
        ContentValues values = new ContentValues();
        values.put(USER_DB.CreateDB.USERPW, userpw);
        return uDB.update(USER_DB.CreateDB._TABLENAME0, values, "user_id=" + userid, null) > 0;
    }
}
