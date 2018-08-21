package sun.xiaolei.design_pattern.iterator;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public abstract class AbsrtactHandler {

    private AbsrtactHandler nextHandler;

    public void handleRequest(AbstractRequest request) {
        //判断当前处理者对象的处理级别是否与请求者的处理级别一样
        if (getHandlerLevel() == request.getRequestLevel()) {
            //一致则由该对象处理
            handle(request);
        } else {
            //否则将该请求对象转发给下一个节点上的请求对象
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                //所有对象都不能处理时
                System.out.println("can not handle request");
            }
        }
    }

    /**
     * 获取处理者对象的处理级别
     *
     * @return
     */
    protected abstract int getHandlerLevel();

    /**
     * 每个处理者对象的具体处理方式
     *
     * @param request
     */
    protected abstract void handle(AbstractRequest request);

    public void setNextHandler(AbsrtactHandler handler) {
        this.nextHandler = handler;
    }

}
