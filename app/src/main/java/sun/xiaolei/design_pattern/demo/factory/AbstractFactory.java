package sun.xiaolei.design_pattern.demo.factory;

/**
 * @author sun
 * description:抽象工厂类
 * <p>
 * 抽象工厂是围绕一个超级工厂创建其他工厂，该超级工厂又称为其他工厂的工厂。
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。
 * 有N个产品族，在抽象工厂类中就应该有N个创建方法
 */
public abstract class AbstractFactory {

    public abstract Product createProduct();

    public abstract Product2 createProduct2();

}
