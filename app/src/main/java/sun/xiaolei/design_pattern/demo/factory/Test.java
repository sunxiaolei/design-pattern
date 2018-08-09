package sun.xiaolei.design_pattern.demo.factory;

/**
 * @author sun
 * description:
 * 定义：定义一个用于创建对象的接口，让子类决定实例化哪个类
 * 使用场景：在任何需要生成复杂对象的地方，都可以使用工厂模式。复杂对象适合使用工厂模式，
 * 用new就可以完成创建的对象无需使用工厂模式。
 * <p>
 * 简单（静态）工厂模式 {@link Product,StaticFactory}
 * 普通工厂模式 {@link Product,Factory,ConcreateFactory}
 * 多工厂模式 {@link Product,MultiFactory,MultiFactoryA,MultiFactoryB}
 * 抽象工厂模式 {@link Product,Product2,AbstractFactory,AbstractConcreateFactory}
 */
public class Test {

    public static void main(String[] args) {

        //静态工厂
        Product p1 = StaticFactory.createProduct(0);
        p1.method();

        //普通工厂
        Factory factory = new ConcreateFactory();
        Product p2 = factory.createProduct(ConcreateProductB.class);
        p2.method();

        //多工厂
        MultiFactory multiFactory = new MultiFactoryA();
        Product p3 = multiFactory.createProduct();
        p3.method();

        //抽象工厂
        AbstractFactory abstractFactory = new AbstractConcreateFactory();
        Product p4 = abstractFactory.createProduct();
        p4.method();
        Product2 p5 = abstractFactory.createProduct2();
        p5.method2();

    }
}
