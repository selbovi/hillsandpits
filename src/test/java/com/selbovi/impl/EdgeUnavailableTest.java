package com.selbovi.impl;

import com.selbovi.SearchDirectionEnum;
import com.selbovi.WaterCalculator;
import com.selbovi.exception.NoEdgeAvailableException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class EdgeUnavailableTest {

    private final int hillIdx;
    private final int[] landscape;
    private final SearchDirectionEnum direction;

    public EdgeUnavailableTest(int hillIdx, int[] landscape, SearchDirectionEnum direction) {
        this.hillIdx = hillIdx;
        this.landscape = landscape;
        this.direction = direction;
    }

    WaterCalculatorImpl calculator = new WaterCalculatorImpl();

    @Test(expected = NoEdgeAvailableException.class)
    public void edgeUnavailable() throws NoEdgeAvailableException {
        calculator.getEdgesHeight(
                hillIdx,
                landscape,
                direction
        );

    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][]{
                        {2, new int[]{3, 0, 3}, SearchDirectionEnum.RIGHT},
                        {0, new int[]{3, 2, 1}, SearchDirectionEnum.RIGHT},
                        {0, new int[]{3, 3, 3}, SearchDirectionEnum.RIGHT},
                        {0, new int[]{3, 0, 3}, SearchDirectionEnum.LEFT},
                        {2, new int[]{1, 2, 3}, SearchDirectionEnum.LEFT},
                        {2, new int[]{3, 3, 3}, SearchDirectionEnum.LEFT},
                }
        );
    }

}
