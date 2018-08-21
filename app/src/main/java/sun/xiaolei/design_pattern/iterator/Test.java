package sun.xiaolei.design_pattern.iterator;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:责任链模式
 * 行为型设计模式
 * <p>
 * 定义：使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它位为止。
 * 场景：多个对象可以处理同一请求，但具体由哪个对象处理则在运行时动态决定。
 * 在请求处理者不明确的情况下向多个对象中的一个提交一个请求。
 * 需要动态指定一组对象处理请求。
 * <p>
 * 角色：
 * 抽象处理者：声明一个请求处理的方法，并指明下一个处理者对象。{@link AbsrtactHandler}
 * 具体处理者：具体处理对象，如果处理不了则交给下一个处理者处理。{@link Handler0,Handler1}
 * 抽象请求者：声明获取请求级别的方法，与处理者返回的处理级别保持对应。{@link AbstractRequest}
 * 具体请求者：{@link Request1,Request2}
 * <p>
 * 场景：
 * 源码-Android事件分发
 * 日常业务-审批流程
 * <p>
 * 总结：
 * 优先显而易见，可以对请求者和处理者关系解偶，提高代码灵活性。
 * 最大缺点是对链中请求处理者的遍历，如果处理者太多会影响性能。
 */
public class Test {

    public static void main(String[] args) {
        AbsrtactHandler handler0 = new Handler0();
        AbsrtactHandler handler1 = new Handler1();
        handler0.setNextHandler(handler1);

        AbstractRequest request1 = new Request1();
        AbstractRequest request2 = new Request2();

        System.out.println("handle request1");
        handler0.handleRequest(request1);
        System.out.println("handle request2");
        handler0.handleRequest(request2);
    }
}
