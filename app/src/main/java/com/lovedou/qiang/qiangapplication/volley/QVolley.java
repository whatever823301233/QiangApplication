package com.lovedou.qiang.qiangapplication.volley;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

import java.io.File;

/**
 * Created by Qiang on 2016/7/15.
 */
public class  QVolley {

    private static final String TAG="QVolley";
    private static QVolley instance;
    private Context context;
    private RequestQueue requestQueue;

    /**
     * 默认缓存目录为tag
     */
    private static final String DEFAULT_CACHE_DIR = TAG;


    private QVolley(Context context){
        this.context=context.getApplicationContext();
        requestQueue= Volley.newRequestQueue(this.context);
    }

    public QVolley getInstance( Context context) {
        if(context==null){
            throw new IllegalArgumentException("Context can not be null! ");
        }
        if(instance==null){
            synchronized (QVolley.class){
                if(instance==null){
                    instance=new QVolley(context);
                }
            }
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }


    /**
     * 将请求添加到队列中
     *
     * @param request
     */
    public <T> void addToRequestQueue(Request<T> request, String tag) {
        // 如果tag为空，则添加默认标记
        request.setTag(null == tag || "".equals(tag) ? TAG : tag);
        // 添加到消息队列中
        getRequestQueue().add(request);
    }

    /**
     * 通过tag取消队列中的请求
     *
     * @param tag
     *            消息标记
     */
    public void cancelFromRequestQueue(String tag) {
        getRequestQueue().cancelAll(null == tag ? TAG : tag);
    }

    /**
     * 创建一个新的队列
     *
     * @param context
     *            app全局上下文
     * @param stack
     *            网络类型
     * @return 队列

    public static RequestQueue newRequestQueue(Context context, HttpStack stack) {
        File cacheDir = new File(context.getCacheDir(), "".equals(DEFAULT_CACHE_DIR) || null == DEFAULT_CACHE_DIR ? TAG
                        : DEFAULT_CACHE_DIR);

        String userAgent = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    packageName, 0);
            userAgent = packageName + "/" + info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }

        if (stack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                stack = new HurlStack();
            } else {
                // Prior to Gingerbread, HttpUrlConnection was unreliable.
                // See:
                // http://android-developers.blogspot.com/2011/09/androids-http-clients.html
                stack = new HttpClientStack(
                        AndroidHttpClient.newInstance(userAgent));
            }
        }

        Network network = new BasicNetwork(stack);

        RequestQueue queue = new RequestQueue(new DiskBasedCache(cacheDir),
                network);
        queue.start();
        return queue;
    } */



    public void destroy(){
        requestQueue=null;
    }

}
