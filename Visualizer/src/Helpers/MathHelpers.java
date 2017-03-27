package Helpers;

import java.util.Random;

/**
 * Created by lajtman on 24-03-2017.
 */
public class MathHelpers {
    private static Random random = new Random();

    public static double gaussian(double mean, double deviation) {
        return Math.abs(random.nextGaussian() * deviation) + mean;
    }
}
