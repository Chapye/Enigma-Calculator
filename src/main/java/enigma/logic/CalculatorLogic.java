package enigma.logic;

public class CalculatorLogic {

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
}
