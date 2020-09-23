package enigma;

import java.io.IOException;

import enigma.logic.CalculatorLogic;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@SuppressWarnings("all") // For VScode users to disable transitive dep warnings
public class PrimaryController {
    @FXML
    public TextField MainDisplay;
    public TextField MiniDisplay;
    public Button EqualsButton;
    CalculatorLogic logic = new CalculatorLogic();

    @FXML
    public void initialize() {

        // unfocus pathField
        Platform.runLater(() -> EqualsButton.requestFocus());
    }

    @FXML
    private void switchToSecondary() throws IOException {
        EnigmaCalculatorMain.setRoot("secondary");
    }

    @FXML
    public void processDigit(Event buttonevent) {
        if (MainDisplay.getText().equals("NaN") || MainDisplay.getText().equals("Infinity")
                || MainDisplay.getText().equals("0")) {
            MainDisplay.setText("");
            Object node = buttonevent.getSource();
            Button b = (Button) node;
            MainDisplay.setText(b.getText());

        } else {
            Object node = buttonevent.getSource();
            Button b = (Button) node;
            MainDisplay.setText(MainDisplay.getText() + b.getText());
        }
    }

    @FXML
    public void processDigit(char digit) {

        if (MainDisplay.getText().equals("NaN") || MainDisplay.getText().equals("Infinity")
                || MainDisplay.getText().equals("0")) {
            MainDisplay.setText("");
            MainDisplay.setText("" + digit);
        } else {
            MainDisplay.setText(MainDisplay.getText() + digit);
        }
    }

    @FXML
    public void processEqual() {
    }

    @FXML
    public void processAddition() {
        try {
            if(logic.getStoredOperator().equals(CalculatorLogic.CalculatorOperator.NONE)){
                logic.setStoredValue(Double.parseDouble(MainDisplay.getText()));
                logic.setStoredOperator(CalculatorLogic.CalculatorOperator.ADDITION);
                MainDisplay.setText("");
                MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+ whichOperator());}
            else
            {
                logic.setStoredValue(whichOperatorMethodHaveToCall());
                logic.setStoredOperator(CalculatorLogic.CalculatorOperator.ADDITION);
                MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
                MainDisplay.setText("");
     
     
            }
        }catch (NumberFormatException e){
            logic.setStoredOperator(CalculatorLogic.CalculatorOperator.ADDITION);
            MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
        }
    }

    @FXML
    public void processSubtraction() {
        try{
            if(logic.getStoredOperator().equals(CalculatorLogic.CalculatorOperator.NONE)){
                logic.setStoredValue(Double.parseDouble(MainDisplay.getText()));
                logic.setStoredOperator(CalculatorLogic.CalculatorOperator.SUBTRACTION);
                MainDisplay.setText("");
                MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+ whichOperator());}
            else
            {
                logic.setStoredValue(whichOperatorMethodHaveToCall());
                logic.setStoredOperator(CalculatorLogic.CalculatorOperator.SUBTRACTION);
                MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
                MainDisplay.setText("");


            }
        }catch (NumberFormatException e){
            logic.setStoredOperator(CalculatorLogic.CalculatorOperator.SUBTRACTION);
            MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
        }
    }

    @FXML
    public void processMultiplication() {
        try {if(logic.getStoredOperator().equals(CalculatorLogic.CalculatorOperator.NONE)){
            logic.setStoredValue(Double.parseDouble(MainDisplay.getText()));
            logic.setStoredOperator(CalculatorLogic.CalculatorOperator.MULTIPLICATION);
            MainDisplay.setText("");
            MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+ whichOperator());}
        else
        {
            logic.setStoredValue(whichOperatorMethodHaveToCall());
            logic.setStoredOperator(CalculatorLogic.CalculatorOperator.MULTIPLICATION);
            MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
            MainDisplay.setText("");

        }

        }catch (NumberFormatException e){
            logic.setStoredOperator(CalculatorLogic.CalculatorOperator.MULTIPLICATION);
            MiniDisplay.setText(String.valueOf(logic.getStoredValue())+" "+whichOperator());
        }
    }

    @FXML
    public void processDivision() {
    }

    @FXML
    public void processExponentiation() {
    }

    @FXML
    public void processPercentage() {
    }

    @FXML
    public void processNegate() {
    }

    @FXML
    public void processDecimal() {
    }

    @FXML
    public void processClear() {
        setDisplay(MainDisplay, 0);
    }

    @FXML
    public void processAllClear() {
        logic.setStoredValue(0.0);
        logic.setStoredOperator(CalculatorLogic.CalculatorOperator.NONE);
        setDisplay(MainDisplay, 0);
        setDisplay(MiniDisplay, "");
        MainDisplay.setStyle("-fx-font: 36 System");
    }

    @FXML
    public void processBackspace() {
    }

    private void setDisplay(TextField mainDisplay, double storedValue, String s) {
        if ((int) storedValue == storedValue)
            mainDisplay.setText(String.valueOf((int) storedValue) + " " + s);
        else
            mainDisplay.setText(String.valueOf(storedValue) + " " + s);
    }

    private void setDisplay(TextField display, String message) {
        display.setText(message);
    }

    private void setDisplay(TextField mainDisplay, double storedValue) {
        if ((int) storedValue == storedValue)
            mainDisplay.setText(String.valueOf((int) storedValue));
        else
            mainDisplay.setText(String.valueOf(storedValue));
    }

    String whichOperator(){
        switch(logic.getStoredOperator()) {
            case ADDITION:
                return "+";
            case SUBTRACTION:
                return "-";
            case MULTIPLICATION:
                return "*";
            case DIVISION:
                return "/";
            case POWER:
                return "^";
            case PERCENTAGE:
                return "%";
        }

        return null;
    }

    double whichOperatorMethodHaveToCall(){
        switch(logic.getStoredOperator()) {
            case ADDITION:
                return logic.additionOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
            case SUBTRACTION:
                return logic.subtractionOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
            case MULTIPLICATION:
                return logic.multiplicationOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
            case DIVISION:
                return logic.divisionOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
            case POWER:
                return logic.nthPowerOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
            case PERCENTAGE:
                return logic.percentageOperator(logic.getStoredValue(), Double.parseDouble(MainDisplay.getText()));
        }
        return 0;
    }

}
