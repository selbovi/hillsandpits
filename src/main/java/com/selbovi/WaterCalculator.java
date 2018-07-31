package com.selbovi;

/**
 * Applications "heart" interface.
 */
public interface WaterCalculator {
    /**
     * Contract for apps main logic.
     *
     * @param landscape set of hills
     * @return amount of water traped by the landscape
     */
    long calculateWaterAmount(
            int[] landscape
    );
}

