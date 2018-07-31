package com.selbovi.impl;

import com.selbovi.SearchDirectionEnum;
import com.selbovi.WaterCalculator;
import com.selbovi.exception.NoEdgeAvailableException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EdgesHeightTest {

    private final int hillIdx;
    private final int[] landscape;
    private final SearchDirectionEnum direction;
    private int expected;

    public EdgesHeightTest(int hillIdx, int[] landscape, SearchDirectionEnum direction, int result) {
        this.hillIdx = hillIdx;
        this.landscape = landscape;
        this.direction = direction;
        this.expected = result;
    }

    WaterCalculatorImpl calculator = new WaterCalculatorImpl();

    @Test
    public void edgesHeight() throws NoEdgeAvailableException {
        int edgesHeight = calculator.getEdgesHeight(
                hillIdx,
                landscape,
                direction
        );

        assertEquals(expected, edgesHeight);
    }


    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {2, new int[]{0, 6, 3}, SearchDirectionEnum.LEFT, 6},
                        {6, new int[]{0, 761, 3, 650, 1, 8, 10, 15}, SearchDirectionEnum.LEFT, 761},
                        {6, new int[]{800, 761, 3, 650, 1, 8, 10, 15}, SearchDirectionEnum.LEFT, 800},
                        {6, new int[]{800, 800, 3, 650, 1, 8, 10, 15}, SearchDirectionEnum.LEFT, 800},
                        {0, new int[]{3, 0, 5}, SearchDirectionEnum.RIGHT, 5},
                        {0, new int[]{3, 0, 5, 100, 500}, SearchDirectionEnum.RIGHT, 500},
                        {0, new int[]{3, 0, 5, 500, 500}, SearchDirectionEnum.RIGHT, 500},
                        {0, new int[]{3, 0, 5, 500, 499}, SearchDirectionEnum.RIGHT, 500}
                }
        );
    }

}
