package sun.xiaolei.design_pattern.iterator;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class Handler1 extends AbsrtactHandler {
    @Override
    protected int getHandlerLevel() {
        return 1;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("handle by Handler1");
    }

}
