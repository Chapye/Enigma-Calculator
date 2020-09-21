package enigma;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    public void processDigit(){}

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
    public void processClear() {}

    @FXML
    public void processAllClear() {}

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
