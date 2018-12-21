package com.example.anuo.myseven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class NotFindAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_find_acitivity);
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSeaBlue));
        TextView textView = (TextView) findViewById(R.id.txt_nofind);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("notfind"));

    }
}
