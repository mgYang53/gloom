package com.example.gloom;

import android.provider.BaseColumns;

public final class ANALYSIS_DB {

    public static final class CreateDB implements BaseColumns {
        public static final String DATE = "analyze_date";
        public static final String RESULT = "result";
        public static final String USER_IDX = "user_idx";
        public static final String _TABLENAME0 = "analysistable";
        public static final String _CREATE0 = "create table if not exists " + _TABLENAME0 + "("
                + DATE + " text primary key , "
                + RESULT + " integer not null , "
                + USER_IDX + " integer not null , foreign key( "
                + USER_IDX + ") references"
                + USER_DB.CreateDB._TABLENAME0 + "(" + USER_DB.CreateDB._ID + "));";

    }
}
