package com.example.gloom;

import android.provider.BaseColumns;

public final class DIARY_DB {

    public static final class CreateDB implements BaseColumns {
        public static final String DATE = "write_date";
        public static final String CONTENT = "content";
        public static final String USER_IDX = "user_idx";
        public static final String _TABLENAME0 = "diarytable";
        public static final String _CREATE0 = "create table if not exists " + _TABLENAME0 + "("
                + _ID + " integer primary key autoincrement, "
                + DATE + " text primary key , "
                + CONTENT + " text not null , "
                + USER_IDX + " integer not null , foreign key( "
                + USER_IDX + ") references"
                + USER_DB.CreateDB._TABLENAME0 + "(" + USER_DB.CreateDB._ID + "));";

    }
}
