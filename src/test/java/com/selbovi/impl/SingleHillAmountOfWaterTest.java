package com.selbovi.impl;

import com.selbovi.WaterCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SingleHillAmountOfWaterTest {

    public SingleHillAmountOfWaterTest(int hillIdx, int[] landscape, int expected) {
        this.hillIdx = hillIdx;
        this.landscape = landscape;
        this.expected = expected;
    }

    private final int hillIdx;
    private final int[] landscape;
    private int expected;
    WaterCalculatorImpl calculator = new WaterCalculatorImpl();

    @Test
    public void getAmountOfWaterSingleHillHolds() {
        long amountOfWaterPerSingleHill = calculator.getAmountOfWaterSingleHillHolds(hillIdx, landscape);
        assertEquals(expected, amountOfWaterPerSingleHill);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {1, new int[]{3, 0, 3}, 3},
                        {1, new int[]{2, 0, 3}, 2},
                        {1, new int[]{2, 1, 3}, 1},
                        {2, new int[]{20, 1, 3, 5, 10}, 7}
                }
        );
    }
}
