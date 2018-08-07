package sun.xiaolei.design_pattern.demo.singleton;

/*
 * @author sun
 * description:懒汉式
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
