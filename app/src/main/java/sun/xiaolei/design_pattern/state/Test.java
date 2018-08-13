package sun.xiaolei.design_pattern.state;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:状态模式
 * <p>
 * 定义：当一个对象的内部状态改变时允许改变其行为，这个对象看起来像是改变了其类。
 * <p>
 * 场景：
 * 1.一个对象的行为取决于它的状态，并且他必须在运行时根据状态改变他的行为。
 * 2.代码中包含大量与对象状态有关的条件语句。
 * <p>
 * 角色：
 * 环境类(Context)，维护一个State子类的实例，这个实例定义了对象的当前状态。
 * 抽象状态类或状态接口(State)，定义一个或一组接口，表示该状态下的行为。
 * 具体状态类(ConcreteState)
 * <p>
 * 例：电视在开机和关机的状态下操作是不同的。
 * 遥控器，Context类 {@link TvController}
 * 电视的状态行为饥接口 {@link TvState}
 * 开关机状态下行为的具体实现 {@link PowerOnState,PowerOffState}
 */
public class Test {

    public static void main(String[] args) {

        TvController controller = new TvController();
        controller.powerOn();
        controller.nextChannel();
        controller.turnUp();
        controller.powerOff();
        controller.turnUp();
    }
}
