package sun.xiaolei.design_pattern.singleton;

/*
 * @author sun
 * description:内部静态类单例
 */
public class InnerSingleton {

    private InnerSingleton() {

    }

    public static InnerSingleton getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final InnerSingleton instance = new InnerSingleton();
    }
}
