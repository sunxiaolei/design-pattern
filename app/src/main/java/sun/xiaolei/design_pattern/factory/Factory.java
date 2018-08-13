package sun.xiaolei.design_pattern.factory;

/**
 * @author sun
 * description:工厂模式
 */
public abstract class Factory {

    public abstract Product createProduct(Class<? extends Product> clz);

}
