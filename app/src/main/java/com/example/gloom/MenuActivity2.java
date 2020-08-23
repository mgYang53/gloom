package com.example.gloom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuActivity2 extends AppCompatActivity {

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm:ss");
    String formatDate = sdfNow.format(date);
    TextView dateNow;
    Button bt;
    TextInputEditText diary;

    private DIARYDBOpenHelper dDbOpenHelper;
    private ANALYSISDBOpenHelper aDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        TextView tv1 = (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();
        String day = intent.getExtras().getString("day");

        tv1.setText(day);

        dateNow = (TextView) findViewById(R.id.textViewd);
        dateNow.setText(formatDate);

        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new MyListener4());

        diary = (TextInputEditText) findViewById(R.id.textInputEditText);

        dDbOpenHelper = new DIARYDBOpenHelper(this);
        dDbOpenHelper.open();
        dDbOpenHelper.create();



    }

    class MyListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            now = System.currentTimeMillis();
            date = new Date(now);
            SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm:ss");
            String formatDate = sdfNow.format(date);
            dateNow.setText(formatDate);
        } // end onClick
    }

    public void onBackPressed() {
        finish();
    }
}