package com.zhy.sample_okhttp.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.sample_okhttp.R;

public class HttpsActivity extends AppCompatActivity {

    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_https);

        resultTv = (TextView)findViewById(R.id.https_resultShow);
    }


    public void httpClick(View view)
    {
        String url = "http://192.168.56.1:8080/";

        OkHttpUtils
                .get()//
                .url(url)//
                .build()//
                .execute(new MyStringCallback());

    }
    public void httpsClick(View view)
    {
        String url = "https://192.168.56.1:8443/";

        OkHttpUtils
                .get()//
                .url(url)//
                .build()//
                .execute(new MyStringCallback());

    }

    public class MyStringCallback extends StringCallback
    {
        @Override
        public void onBefore(Request request)
        {
            super.onBefore(request);
        }

        @Override
        public void onAfter()
        {
            super.onAfter();
        }

        @Override
        public void onError(Request request, Exception e)
        {
            resultTv.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response)
        {
            resultTv.setText("onResponse:" + response);
        }

        @Override
        public void inProgress(float progress)
        {

        }
    }
}
