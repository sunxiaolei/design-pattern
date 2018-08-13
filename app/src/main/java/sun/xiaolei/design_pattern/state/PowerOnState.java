package sun.xiaolei.design_pattern.state;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:开机状态
 */
public class PowerOnState implements TvState {

    @Override
    public void nextChannel() {
        System.out.println("下个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("上个频道");
    }

    @Override
    public void turnUp() {
        System.out.println("调大音量");
    }

    @Override
    public void turnDown() {
        System.out.println("调小音量");
    }
}
