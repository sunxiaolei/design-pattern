package sun.xiaolei.design_pattern.strategy;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class SubwayCalcStategy implements CalcStrategy {

    @Override
    public void calc() {
        System.out.println("地铁计费");
    }
}
