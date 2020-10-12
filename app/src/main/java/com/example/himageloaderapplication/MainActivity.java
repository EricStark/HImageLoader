package com.example.himageloaderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.himageloaderlibrary.HImageLoader;
import com.example.himageloaderlibrary.cache.DoubleCacheStrategy;
import com.example.himageloaderlibrary.compress.LosslessCpmpress;
import com.example.himageloaderlibrary.config.RequestConfig;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView = null;
    private RequestConfig config = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 设置参数 得到config对象
         */
        config = new RequestConfig.Builder(this)
                .from("https://upload-images.jianshu.io/upload_images/2441545-6aeb5a737351879c.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp")  //设置图片地址
                .error(R.drawable.bu)  //设置加载失败时的占位图
                .placeHolder(R.drawable.bu)  //设置加载未完成前的占位图
                .compressionStrategy(LosslessCpmpress.getInstance()) //设置图片压缩策略
                .size(200, 200) //图片大小
                .cacheStrategy(DoubleCacheStrategy.getInstance())   //设置图片缓存策略
                .cacheDir("/sdcard/cache")  //设置缓存目录
                .quality(100)   //设置图片质量（1-100）
                .scaleType(ImageView.ScaleType.CENTER_CROP)
                .build();  //设置图片的scaleType.build();
        //图片展示的imageview
        imageView = findViewById(R.id.iv);
        //展示图片
        HImageLoader.displayImage(imageView,config);

    }
}
