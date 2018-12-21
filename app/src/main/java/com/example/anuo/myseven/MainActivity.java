package com.example.anuo.myseven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Novel> novelList = new ArrayList<>();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSeaBlue));
        initTitle();
        ImageView imgsearch = (ImageView) findViewById(R.id.img_search);
        final ProgressBar pbrsearch = (ProgressBar) findViewById(R.id.pbr_search);
        editText = (EditText) findViewById(R.id.edt_search);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.view_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ListAdapter listAdapter = new ListAdapter(novelList);
        recyclerView.setAdapter(listAdapter);
        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.img_search) {
                    sendRequestWithHttpURLConnection();
                }
            }
        });
    }


    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.apiopen.top/novelSearchApi?name=盗墓笔记");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder databack = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        databack.append(line);
                    }
                    AboutResult(databack.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void AboutResult(final String databack) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONObject mJSONObject;
                {
                    try {
                        mJSONObject = new JSONObject(databack);
                        JSONArray array = mJSONObject.getJSONArray("data");
                        int num = 0;
                        for (int i = 0; i < array.length(); i++) {
                            if (array.get(i).toString().equals(editText.getText().toString())) {
                                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                intent.putExtra("bookdata", array.get(i).toString());
                                startActivity(intent);
                            } else {
                                num = num + 1;
                                System.out.println(num);
                                if (num == (array.length())) {
                                    Intent intent = new Intent(MainActivity.this, NotFindAcitivity.class);
                                    intent.putExtra("notfind", "not find the book");
                                    startActivity(intent);
                                }
                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initTitle() {
        for (int i = 0; i < 10; i++) {
            Novel book1 = new Novel("book1");
            novelList.add(book1);
            Novel book2 = new Novel("book2");
            novelList.add(book2);
            Novel book3 = new Novel("book3");
            novelList.add(book3);
        }
    }
}


