package sun.xiaolei.design_pattern.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @author sun
 * description:
 */
public class ImageLoader {

    private static Context mContext;
    /**
     * 图片缓存
     */
    private ImageCache mImageCache;
    private static ImageLoaderConfig mConfig;

    /**
     * 线程池
     */
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final ImageLoader instance = new ImageLoader();
    }

    public void init(ImageLoaderConfig config) {
        mContext = config.getContext();
        mConfig = config;
        mExecutorService = Executors.newFixedThreadPool(mConfig.getThreadPoolNum());
        mImageCache = config.getCachePolicy();
    }

    public static Context getContext() {
        if (mContext == null) {
            throw new NullPointerException("should init first");
        }
        return mContext;
    }

    public static ImageLoaderConfig getConfig() {
        if (mConfig == null) {
            throw new NullPointerException("should init first");
        }
        return mConfig;
    }

    private Bitmap downloadImage(String imgUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private void submitTask(final String url, final ImageView iv) {
        iv.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("download image");
                final Bitmap bitmap = downloadImage(url);
                if (bitmap != null) {
                    mImageCache.put(url, bitmap);
                    if (url.equals(iv.getTag())) {
                        iv.post(new Runnable() {
                            @Override
                            public void run() {
                                iv.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            }
        });
    }

    public void show(final String url, final ImageView iv) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap != null) {
            iv.setImageBitmap(bitmap);
            return;
        }
        submitTask(url, iv);
    }

}
