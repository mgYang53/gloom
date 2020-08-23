package com.example.gloom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView mbt;
    ImageView pbt;
    CalendarView cbt;
    TextView getdate;
    ImageView wbt;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.M.d");
    SimpleDateFormat cFormat = new SimpleDateFormat("yyyyMd");
    String tday;
    String sday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbt  = (ImageView) findViewById(R.id.mbt);
        mbt.setImageResource(R.drawable.mbt);
        mbt.setOnClickListener(new MyListener());

        pbt  = (ImageView) findViewById(R.id.pbt);
        pbt.setImageResource(R.drawable.pbt);
        pbt.setOnClickListener(new MyListener2());

        wbt = (ImageView) findViewById(R.id.water);
        wbt.setOnClickListener(new MyListener4());

        getdate = (TextView) findViewById(R.id.getdate);
        Date date = new Date();
        String time = mFormat.format(date);
        getdate.setText(time);
        time = cFormat.format(date);
        tday = time;
        sday = time;

        cbt = (CalendarView) findViewById(R.id.calendarView);
        cbt.setOnDateChangeListener(new CalendarView.OnDateChangeListener() // 날짜 선택 이벤트
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                String date = year + "." + (month + 1) + "." + dayOfMonth;
                getdate.setText(date); // 선택한 날짜로 설정
                sday = year + "" + (month + 1) + dayOfMonth;

            }
        });



    }
    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            overridePendingTransition(R.anim.in_left,R.anim.out_right);
            startActivity(intent);
        } // end onClick
    }
    class MyListener2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(tday.equals(sday)) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity2.class);
                intent.putExtra("day", getdate.getText());
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"오늘 날짜가 아니면 일기를 추가 할 수 없어요ㅠㅠ",Toast.LENGTH_SHORT).show();
            }
        } // end onClick
    }
    class MyListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            intent.putExtra("day",getdate.getText());
            startActivity(intent);
        } // end onClick
    }
}
