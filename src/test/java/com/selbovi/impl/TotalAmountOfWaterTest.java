package com.selbovi.impl;

import com.selbovi.WaterCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TotalAmountOfWaterTest {

    public TotalAmountOfWaterTest(int[] landscape, int expected) {
        this.landscape = landscape;
        this.expected = expected;
    }

    private final int[] landscape;
    private int expected;
    WaterCalculator calculator = new WaterCalculatorImpl();

    @Test
    public void getTotalAmountOfWater() {
        long totalAmount = calculator.calculateWaterAmount(landscape);
        assertEquals(expected, totalAmount);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{5, 3, 7, 2, 6, 4, 5, 9, 1, 2}, 14},
                        {new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1}, 9}
                }
        );
    }
}
