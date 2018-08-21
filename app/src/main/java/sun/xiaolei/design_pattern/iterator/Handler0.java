package sun.xiaolei.design_pattern.iterator;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class Handler0 extends AbsrtactHandler {
    @Override
    protected int getHandlerLevel() {
        return 0;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("Handle by Handler0");
    }
}
