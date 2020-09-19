package enigma;

import java.io.IOException;
import javafx.fxml.FXML;

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

    
}
