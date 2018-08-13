package sun.xiaolei.design_pattern.state;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:电视状态接口，定义了电视操作的函数
 */
public interface TvState {

    void nextChannel();

    void prevChannel();

    void turnUp();

    void turnDown();
}
