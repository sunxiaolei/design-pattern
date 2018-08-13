package sun.xiaolei.design_pattern.strategy;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:策略模式
 * 行为型模式
 * <p>
 * 定义：策略模式定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。
 * 策略模式让算法独立于使用它的客户而独立变化。
 * <p>
 * 场景：
 * 针对同一类型问题的多种查理方式，仅仅是具体行为有差别时。
 * 需要安全地封装多种同一类型的操作时。
 * 出现同一抽象类有多个子类，而又需要if...else或switch来选择具体子类时。
 * <p>
 * 涉及到三个角色：
 * 抽象策略(Strategy)角色：这是一个抽象角色，通常由接口或抽象类实现。给出所有的具体策略类所需的接口。
 * 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
 * 环境(Context)角色：持有一个Strategy的引用。
 * <p>
 * 例：出行选择交通工具，相同的距离乘坐公交和乘坐地铁票价的计算方式是不同的。
 * 计算价格的策略接口 {@link CalcStrategy}
 * 具体的计算实现类 {@link BusCalcStategy,SubwayCalcStategy}
 * 环境类 {@link CalcContext}
 * <p>
 * 当需要扩展时例如新加出租车计费，直接增加出租车策略类即可。
 */
public class Test {

    public static void main(String[] args) {
        CalcContext calc = new CalcContext();
        calc.setStrategy(new BusCalcStategy());
        calc.calc();
    }
}
