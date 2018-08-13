package sun.xiaolei.design_pattern.factory;

/**
 * @author sun
 * description:静态工厂
 */
public class StaticFactory {

    public static final int TYPE_A = 0;
    public static final int TYPE_B = 1;

    /**
     * 根据条件决定一个接口由哪个具体产品类来实现
     *
     * @param type 类型
     * @return 具体产品
     */
    public static Product createProduct(int type) {
        switch (type) {
            case TYPE_A:
                return new ConcreateProductA();
            case TYPE_B:
                return new ConcreateProductB();
            default:
                return new ConcreateProductA();
        }
    }

    /**
     * 利用反射返回产品对象
     *
     * @param clz 产品对象类类型
     * @return 具体产品
     */
    public static Product createProduct(Class<? extends Product> clz) {
        Product p = null;
        try {
            p = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return p;
    }
}
