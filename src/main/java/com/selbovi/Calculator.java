package com.selbovi;

import com.selbovi.impl.WaterCalculatorImpl;

/**
 * For running from cmd.
 */
public class Calculator {

    public static void main(String[] args) {
        long waterAmount = new WaterCalculatorImpl().calculateWaterAmount(toLandscape(args));
        System.out.println("Calculated water amount is: " + waterAmount);
    }

    private static int[] toLandscape(String[] args) {
        int[] hills = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            hills[i] = Integer.parseInt(args[i]);
        }
        return hills;
    }
}
