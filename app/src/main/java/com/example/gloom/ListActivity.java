package com.example.gloom;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    private TextView whenDate;
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");

    private final String db_Name = "gloomDB";
    private final String user_tableName = "user_table";
    private final String diary_tableName = "diary_table";
    private final String analysis_tableName = "analysis_table";

    SQLiteDatabase mainDB = null;

    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String day = intent.getExtras().getString("day");


        whenDate = (TextView) findViewById(R.id.whenDate);
        Date date = new Date();
        String time = mFormat.format(date);
        whenDate.setText(day); // 현재 날짜로 설정

        ListView listView = findViewById(R.id.list_view);
        list = new ArrayList<>();

        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");

        MyAdapter myAdapter = new MyAdapter(ListActivity.this, list);
        listView.setAdapter(myAdapter);

//        try {
//            mainDB = this.openOrCreateDatabase(db_Name, MODE_PRIVATE, null);
//
//            mainDB.execSQL("CREATE TABLE IF NOT EXISTS " + user_tableName + " (user_idx INT)");
//        }



    }

    class MyAdapter extends BaseAdapter{

        private ViewHolder viewHolder;
        private LayoutInflater inflater;
        private ArrayList<String> itemList;

        public MyAdapter(Context context, ArrayList<String> itemList) {
            this.itemList = itemList;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public String getItem(int i) {
            return itemList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view = convertView;
            if(view == null) {
                viewHolder = new ViewHolder();
                view = inflater.inflate(R.layout.diary_list_view, null);
                viewHolder.textView = view.findViewById(R.id.item_view_text);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.textView.setText(getItem(i));

            return view;
        }

        class ViewHolder{
            public TextView textView = null;
        }
    }

}