package com.example.administrator.wushuai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

import static com.example.administrator.wushuai.R.id.listview;

public class MainActivity extends AppCompatActivity
{

    private String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";
    private RecyclerView recyclerView;
    private Status status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



       OkHttp.getAsync(url, new OkHttp.DataCallBack() {
           @Override
           public void requestFailure(Request request, IOException e) {

           }

           @Override
           public void requestSuccess(String result) throws Exception {

               Gson gson=new Gson();

               status=gson.fromJson(result,Status.class);


               recyclerView.setAdapter(new Adapter(status,MainActivity.this));




           }
       });

    }
}
