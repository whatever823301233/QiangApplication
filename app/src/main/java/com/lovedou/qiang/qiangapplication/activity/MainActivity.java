package com.lovedou.qiang.qiangapplication.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.lovedou.qiang.qiangapplication.R;

public class MainActivity extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);
       /* StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });*/

       /* QVolley.getInstance(this).loadImage("https://ss0.bdstatic.com/" +
                "94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_400" +
                "0&sec=1468824088&di=4fe9286700c4e38a3c2c586ad2a0092e&src=http://g.hi" +
                "photos.baidu.com/image/pic/item/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg",
                imageView,R.mipmap.ic_launcher,R.mipmap.ic_launcher);*/

        //QVolley.getInstance(this).addToRequestQueue(stringRequest,"zhang");
        /*AsyncPost post=new AsyncPost("http://www.wangzhiqiang87.cn", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LogUtil.i("","success"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtil.e("","error"+error);
            }
        });
        try {
            post.putParam("account=",URLEncoder.encode("一个大肥人", "UTF-8"));
            post.putParam("pswd",URLEncoder.encode("两个个大肥人", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        QVolley.getInstance(this).addToAsyncQueue(post,"zhang");*/
    }
}
