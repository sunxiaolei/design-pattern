package sun.xiaolei.design_pattern.factory;

/*
 * @author sun
 * description:
 *
 */
public class ConcreateFactory extends Factory {

    @Override
    public Product createProduct(Class<? extends Product> clz) {
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
