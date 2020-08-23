package com.example.gloom;

import android.provider.BaseColumns;

public final class USER_DB {

    public static final class CreateDB implements BaseColumns {
        public static final String USERID = "user_id";
        public static final String USERPW = "user_pw";
        public static final String TEL = "tel";
        public static final String EMAIL = "email";
        public static final String _TABLENAME0 = "usertable";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null , "
                +USERPW+" text not null , "
                +TEL+" text not null , "
                +EMAIL+" text not null );";
    }
}
