package sun.xiaolei.design_pattern.state;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class TvController {

    private TvState mState;

    public void powerOn() {
        mState = new PowerOnState();
        System.out.println("已开机");
    }

    public void powerOff() {
        mState = new PowerOffState();
        System.out.println("已关机");
    }

    public void nextChannel() {
        mState.nextChannel();
    }

    public void prevChannel() {
        mState.prevChannel();
    }

    public void turnUp() {
        mState.turnUp();
    }

    public void turnDown() {
        mState.turnDown();
    }
}
