package sun.xiaolei.design_pattern.factory;

/*
 * @author sun
 * description:
 */
public class AbstractConcreateFactory extends AbstractFactory {

    @Override
    public Product createProduct() {
        return new ConcreateProductA();
    }

    @Override
    public Product2 createProduct2() {
        return new ConcreateProduct2A();
    }


}
