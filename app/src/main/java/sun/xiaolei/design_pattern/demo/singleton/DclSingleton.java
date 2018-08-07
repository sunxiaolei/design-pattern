package sun.xiaolei.design_pattern.demo.singleton;

/*
 * @author sun
 * description:双重校验锁
 */
public class DclSingleton {

    private volatile static DclSingleton instance;

    private DclSingleton() {

    }

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

}
