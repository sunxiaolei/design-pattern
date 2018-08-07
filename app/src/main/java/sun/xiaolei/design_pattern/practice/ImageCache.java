package sun.xiaolei.design_pattern.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static android.os.Environment.isExternalStorageRemovable;

/*
 * @author sun
 * description:
 */
public class ImageCache {

    private static final String TAG = "ImageCache";
    private static final int DISK_MAX_SIZE = 1024 * 1024 * 10;//10M

    private LruCache<String, Bitmap> mMemoryCache;
    private DiskLruCache mDiskCache;

    public ImageCache() {
        //最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一作为缓存
        int cacheSize = maxMemory / 4;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            //重写sizeOf方法，计算出要缓存的每张图片的大小。
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };

        File cacheFile = getDiskCacheDir(ImageLoader.getContext(), "dp_imgloader");
        try {
            mDiskCache = DiskLruCache.open(cacheFile, 1, 1, DISK_MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap get(String key) {
        Bitmap bitmap;
        if (key != null) {
            bitmap = mMemoryCache.get(key);
            if (bitmap != null) {
                Log.d(TAG, "get from memory cache");
                return bitmap;
            }
            try {
                DiskLruCache.Snapshot snapshot = mDiskCache.get(Util.hashKeyForDisk(key));
                if (snapshot != null) {
                    Log.d(TAG, "get from disk cache");
                    bitmap = BitmapFactory.decodeStream(snapshot.getInputStream(0));
                    mMemoryCache.put(key, bitmap);
                    return bitmap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

    public void set(String key, Bitmap bitmap) {
        if (key == null || bitmap == null) {
            return;
        }
        mMemoryCache.put(key, bitmap);
        try {
            //URL经过MD5加密生成唯一的key值，避免URL中可能含有非法字符问题
            DiskLruCache.Editor editor = mDiskCache.edit(Util.hashKeyForDisk(key));
            OutputStream os = editor.newOutputStream(0);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            os.write(baos.toByteArray());
            os.close();
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        //如果已存满或者外存储被移除，缓存目录=context.getCacheDir().getPath()即/data/data/package_name/cache
        //反之缓存目录=context.getExternalCacheDir().getPath()，即 /storage/emulated/0/Android/data/package_name/cache
        final String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !isExternalStorageRemovable()
                ? context.getExternalCacheDir().getPath()
                : context.getCacheDir().getPath();
        return new File(cachePath + File.separator + uniqueName);
    }
}
