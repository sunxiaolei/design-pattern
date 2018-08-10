package sun.xiaolei.design_pattern.demo.strategy;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class CalcContext {

    private CalcStrategy strategy;

    public void setStrategy(CalcStrategy strategy) {
        this.strategy = strategy;
    }

    public void calc() {
        strategy.calc();
    }
}
