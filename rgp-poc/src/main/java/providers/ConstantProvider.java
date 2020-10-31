package providers;

import org.tinylog.Logger;

public class ConstantProvider {

    public static double getPi(){
        Logger.info("getPi runs");
        return StrictMath.PI;
    }

    public static double getEulerConstant(){
        Logger.info("getEulerConstant runs");
        return StrictMath.E;
    }
}
