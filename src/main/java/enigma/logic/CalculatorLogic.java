package enigma.logic;

public class CalculatorLogic {

    public enum CalculatorOperator {
        NONE, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, POWER, PERCENTAGE
    }

    private CalculatorOperator storedOperator;
    private double storedValue;

    public CalculatorLogic() {
        storedOperator = CalculatorOperator.NONE;
        storedValue = 0;
    }


    public CalculatorOperator getStoredOperator() {
        return storedOperator;
    }

    public double getStoredValue() {
        return storedValue;
    }

    public void setStoredOperator(CalculatorOperator storedOperator) {
        this.storedOperator = storedOperator;
    }

    public void setStoredValue(double storedValue) {
        this.storedValue = storedValue;
    }

    public double additionOperator(double x, double y) {

        return x + y;
    }

    public double subtractionOperator(double x, double y) {
        return x - y;
    }

    public double multiplicationOperator(double x, double y) {
        return x * y;
    }

    public double divisionOperator(double x, double y) {
        return x / y;
    }

    public double nthPowerOperator(double x, double n) {
        return Math.pow(x, n);
    }

    public double percentageOperator(double x, double percent) {
        return ( x / 100 ) * percent;
    }
}
