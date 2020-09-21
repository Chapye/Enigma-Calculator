package enigma;

import java.io.IOException;

import enigma.logic.CalculatorLogic;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    public TextField MainDisplay;
    public TextField MiniDisplay;
    public Button EqualsButton;
    CalculatorLogic logic = new CalculatorLogic();
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    public void processDigit(Event buttonevent) {
        if (MainDisplay.getText().equals("NaN") || MainDisplay.getText().equals("Infinity")
                || MainDisplay.getText().equals("0") ) {
            MainDisplay.setText("");
            Object node = buttonevent.getSource();
            Button b = (Button) node;
            MainDisplay.setText(b.getText());

        } else {
            Object node = buttonevent.getSource();
            Button b = (Button) node;
            MainDisplay.setText(MainDisplay.getText() + b.getText());
        }}

    @FXML
    public void processEqual(){}

    @FXML
    public void processAddition() {}

    @FXML
    public void processSubtraction() {}

    @FXML
    public void processMultiplication() {}

    @FXML
    public void processDivision() {}

    @FXML
    public void processExponentiation() {}

    @FXML
    public void processPercentage() {}

    @FXML
    public void processNegate() {}

    @FXML
    public void processDecimal() {}

    @FXML
    public void processClear() {setDisplay(MainDisplay,0);}

    @FXML
    public void processAllClear() {
        logic.setStoredValue(0.0);
        logic.setStoredOperator(CalculatorLogic.CalculatorOperator.NONE);
        setDisplay(MainDisplay,0);
        setDisplay(MiniDisplay,"");
        MainDisplay.setStyle("-fx-font: 36 System");
    }

    @FXML
    public void processBackspace() {}

    private void setDisplay(TextField mainDisplay, double storedValue, String s){
        if((int)storedValue==storedValue)
            mainDisplay.setText(String.valueOf((int)storedValue)+" "+s);
        else
            mainDisplay.setText(String.valueOf(storedValue)+" "+s);
    }


    private void setDisplay(TextField display,String message){
        display.setText(message);
    }

    private  void setDisplay(TextField mainDisplay, double storedValue){
        if((int)storedValue==storedValue)
            mainDisplay.setText(String.valueOf((int)storedValue));
        else
            mainDisplay.setText(String.valueOf(storedValue));
    }
}
