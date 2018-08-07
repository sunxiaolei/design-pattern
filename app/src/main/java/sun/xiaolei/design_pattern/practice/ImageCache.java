package sun.xiaolei.design_pattern.practice;

import android.graphics.Bitmap;

/*
 * @author sun
 * description:
 */
public interface ImageCache {

    Bitmap get(String url);

    void put(String url, Bitmap bitmap);
}
