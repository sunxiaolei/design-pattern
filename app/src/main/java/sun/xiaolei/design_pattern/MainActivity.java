package sun.xiaolei.design_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import sun.xiaolei.design_pattern.practice.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private String imgUrl = "https://developer.android.google.cn/static/images/home/android-p-clear-bg-with-shadow-@1x.png";

    private ImageLoader mImageLoader;

    Button btn, btn2;
    ImageView ivTest, ivTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageLoader = new ImageLoader(this);


        btn = findViewById(R.id.btn_getimg);
        btn2 = findViewById(R.id.btn_getimg2);
        ivTest = findViewById(R.id.iv_test);
        ivTest2 = findViewById(R.id.iv_test2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageLoader.show(imgUrl, ivTest);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageLoader.show(imgUrl, ivTest2);
            }
        });
    }
}
