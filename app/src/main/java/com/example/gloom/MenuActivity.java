package com.example.gloom;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {
    View obt;
    ImageView bbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        obt = (View) findViewById(R.id.view2);
        obt.setOnClickListener(new MyListener3());
        bbt = (ImageView) findViewById(R.id.imageView2);
        bbt.setOnClickListener(new MyListener3());
    }

    class MyListener3 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            finish();
            overridePendingTransition(R.anim.in_right,R.anim.out_left);
        } // end onClick
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.in_right,R.anim.out_left);
    }
}
