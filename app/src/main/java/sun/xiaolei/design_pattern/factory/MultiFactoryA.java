package sun.xiaolei.design_pattern.factory;

/**
 * @author sun
 * description:
 * <p>
 * 多工厂模式，即一个工厂只生产特定的某种产品，实现了单一职责。
 * 创建多个工厂类。各个工厂类中，都对应一个获得接口A实例的方法。用户决定使用哪个工厂。
 */
public class MultiFactoryA extends MultiFactory {
    @Override
    public Product createProduct() {
        return new ConcreateProductA();
    }
}
