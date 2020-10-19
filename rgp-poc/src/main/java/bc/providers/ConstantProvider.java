package providers;

import java.lang.StrictMath;
import org.tinylog.Logger;
import java.lang.Object;


public class ConstantProvider {

    public static double getPi(){
        Logger.info("getPi runs");
        return StrictMath.PI;
    }

    public static double getEulerConstant(){
        Logger.info("getEulerConstant runs");
        return StrictMath.E;
    }

    public static double getGoldenRatio(){
        Logger.info("getGoldenRatio runs");
        double GoldenRatio = (1.0 + StrictMath.sqrt(5)) / 2.0;
        return GoldenRatio;
    }
    public static double getBernsteinConstant(){
        Logger.info("getBernsteinConstant runs");
        double bernstein = 1 / (2.0 * StrictMath.sqrt(StrictMath.PI));
     return bernstein;
    }
}
