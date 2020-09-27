package enigma;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import enigma.logic.CalculatorLogic;

public class CalculatorLogicTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void additionOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(10, calculator.additionOperator(5, 5), 0);
        assertEquals(5, calculator.additionOperator(2.4, 2.6), 0);
        assertEquals(-2, calculator.additionOperator(4, -6), 0);
    }

    @Test
    public void subtractionOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(0, calculator.subtractionOperator(5, 5), 0);
        assertEquals(6, calculator.subtractionOperator(5, -1), 0);
        assertEquals(2.4, calculator.subtractionOperator(1, -1.4), 0);
    }

    @Test

    public void multiplicationOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(8, calculator.multiplicationOperator(2, 4), 0);
        assertEquals(-8, calculator.multiplicationOperator(2, -4), 0);
        assertEquals(0, calculator.multiplicationOperator(2, 0), 0);

    }

    @Test
    public void divisionOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(1, calculator.divisionOperator(4, 4), 0);
        assertEquals(1.6, calculator.divisionOperator(5, 3), 0.1);
        assertTrue(Double.isInfinite(calculator.divisionOperator(4, 0)));
    }

    @Test
    public void nthPowerOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(16, calculator.nthPowerOperator(2, 4), 0);
        assertEquals(2.828, calculator.nthPowerOperator(2, 1.5), 0.001);
        assertEquals(0.0625, calculator.nthPowerOperator(2, -4), 0);
    }

    @Test
    public void percentageOperatorTest() {
        CalculatorLogic calculator = new CalculatorLogic();

        assertEquals(50, calculator.percentageOperator(100, 50), 0);
        assertEquals(13.65, calculator.percentageOperator(42, 32.5), 0);
    }
}
