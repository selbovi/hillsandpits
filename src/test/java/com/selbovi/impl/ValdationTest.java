package com.selbovi.impl;

import com.selbovi.WaterCalculator;
import com.selbovi.exception.HillsHeightRequirementsNotMetException;
import com.selbovi.exception.NotEnoughHillsForPitFormationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ValdationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void notEnoughHillsForPitFormationException() throws NotEnoughHillsForPitFormationException, HillsHeightRequirementsNotMetException {
        thrown.expect(NotEnoughHillsForPitFormationException.class);
        thrown.expectMessage(NotEnoughHillsForPitFormationException.MESSAGE);
        new WaterCalculatorImpl().validate(null);

        thrown.expect(NotEnoughHillsForPitFormationException.class);
        thrown.expectMessage(NotEnoughHillsForPitFormationException.MESSAGE);
        new WaterCalculatorImpl().validate(new int[]{1, 2});
    }

    @Test
    public void hillsHeightRequirementsNotMet() throws NotEnoughHillsForPitFormationException, HillsHeightRequirementsNotMetException {
        thrown.expect(HillsHeightRequirementsNotMetException.class);
        thrown.expectMessage(HillsHeightRequirementsNotMetException.MESSAGE);
        new WaterCalculatorImpl().validate(new int[]{1, 2, 3, 32001});

        thrown.expect(HillsHeightRequirementsNotMetException.class);
        thrown.expectMessage(HillsHeightRequirementsNotMetException.MESSAGE);
        new WaterCalculatorImpl().validate(new int[]{-1, 2, 3, 32000});
    }

}
