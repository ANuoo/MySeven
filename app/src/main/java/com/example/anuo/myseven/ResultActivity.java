package com.example.anuo.myseven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSeaBlue));
        TextView textView = (TextView) findViewById(R.id.txt_result);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("bookdata"));
    }
}
