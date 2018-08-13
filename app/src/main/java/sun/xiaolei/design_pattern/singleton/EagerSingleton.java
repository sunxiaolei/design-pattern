package sun.xiaolei.design_pattern.singleton;

/*
 * @author sun
 * description:饿汉式
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton genInstance() {
        return instance;
    }
}
