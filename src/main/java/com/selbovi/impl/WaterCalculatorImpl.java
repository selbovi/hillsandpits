package com.selbovi.impl;

import com.selbovi.SearchDirectionEnum;
import com.selbovi.WaterCalculator;
import com.selbovi.exception.HillsHeightRequirementsNotMetException;
import com.selbovi.exception.NoEdgeAvailableException;
import com.selbovi.exception.NotEnoughHillsForPitFormationException;

/**
 * WaterCalculatorImpl.
 */
public class WaterCalculatorImpl implements WaterCalculator {

    /**
     * Minimum amount of hills required to form a pit.
     */
    public static final int MIN_HILLS_AMOUNT = 3;

    /**
     * Apps main logic implementation.
     *
     * @param landscape set of hills
     * @return amount of water traped by the landscape
     */
    public long calculateWaterAmount(final int[] landscape) {
        try {
            validate(landscape);
        } catch (NotEnoughHillsForPitFormationException e) {
            System.err.println(e.getMessage());
            return 0;
        } catch (HillsHeightRequirementsNotMetException e) {
            System.err.println(e.getMessage());
            return 0;
        }

        long totalAmountOfWater = 0;
        for (int hillIdx = 0; hillIdx < landscape.length; hillIdx++) {
            totalAmountOfWater += getAmountOfWaterSingleHillHolds(hillIdx, landscape);
        }
        return totalAmountOfWater;
    }

    /**
     * Validation of input data.
     *
     * @param landscape set of hills
     * @throws NotEnoughHillsForPitFormationException
     * @throws HillsHeightRequirementsNotMetException
     */
    public void validate(int[] landscape) throws NotEnoughHillsForPitFormationException, HillsHeightRequirementsNotMetException {
        if (null == landscape || landscape.length < MIN_HILLS_AMOUNT) {
            throw new NotEnoughHillsForPitFormationException();
        }

        for (int i = 0; i < landscape.length; i++) {
            int height = landscape[i];
            if (height > 32000 || height < 0) {
                throw new HillsHeightRequirementsNotMetException();
            }
        }
    }

    /**
     * Calculates the amount of water, above the single hill, specified by hillIdx param.
     *
     * @param hillIdx   index of hill, for which amount of water above is being determined.
     * @param landscape set of hills
     * @return amount of water, above the single hill
     */
    public long getAmountOfWaterSingleHillHolds(final int hillIdx, final int[] landscape) {
        int[] edges = new int[2];
        try {
            edges[0] = getEdgesHeight(hillIdx, landscape, SearchDirectionEnum.LEFT);
            edges[1] = getEdgesHeight(hillIdx, landscape, SearchDirectionEnum.RIGHT);
        } catch (NoEdgeAvailableException e) {
            return 0;
        }

        int currentHeight = landscape[hillIdx];
        if (edges[0] < edges[1]) {
            return edges[0] - currentHeight;
        } else {
            return edges[1] - currentHeight;
        }
    }

    /**
     * Find height of an edge, with respect to the search direction.
     *
     * @param hillIdx   index of hill
     * @param landscape set of hills
     * @param direction search direction
     * @return if there is an edge (the hill who's height is greater than hills dpecified by hillIdx param),
     * then return its height
     * @throws NoEdgeAvailableException if the water couldn't be traped (no edge)
     */
    public int getEdgesHeight(
            final int hillIdx,
            final int[] landscape,
            final SearchDirectionEnum direction
    ) throws NoEdgeAvailableException {
        boolean leftMargin = hillIdx == 0 && direction == SearchDirectionEnum.LEFT;
        boolean rightMargin = hillIdx == landscape.length && direction == SearchDirectionEnum.RIGHT;
        if (leftMargin || rightMargin) {
            throw new NoEdgeAvailableException(
                    hillIdx,
                    landscape,
                    leftMargin ? SearchDirectionEnum.LEFT : SearchDirectionEnum.RIGHT
            );
        }

        int edgesHeight = 0;
        if (direction == SearchDirectionEnum.LEFT) {
            edgesHeight = calculateLeftEdgesHeight(hillIdx, landscape);
        } else {
            edgesHeight = calculateRightEdgesHeight(hillIdx, landscape);
        }

        if (edgesHeight == 0) {
            throw new NoEdgeAvailableException(hillIdx, landscape, SearchDirectionEnum.LEFT);
        }

        return edgesHeight;
    }

    private int calculateRightEdgesHeight(final int hillIdx, final int[] landscape) {
        int edgesHeight = 0;

        for (int i = hillIdx; i < landscape.length; i++) {
            int height = landscape[i];
            if (height > landscape[hillIdx] && height > edgesHeight) {
                edgesHeight = height;
            }
        }
        return edgesHeight;
    }

    private int calculateLeftEdgesHeight(final int hillIdx, final int[] landscape) {
        int edgesHeight = 0;

        for (int i = hillIdx; i >= 0; i--) {
            int height = landscape[i];
            if (height > landscape[hillIdx] && height > edgesHeight) {
                edgesHeight = height;
            }
        }
        return edgesHeight;
    }
}
