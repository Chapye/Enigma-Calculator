package enigma;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class EnigmaCalculatorMain extends Application {

    private static Scene scene;
    private static FXMLLoader fLoader;


    @SuppressWarnings("all") // For an upstream bug to remove anoying warning
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 350, 480);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.getIcons().add(new Image(EnigmaCalculatorMain.class.getResourceAsStream("enigma.png")));
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                PrimaryController controller = (PrimaryController) fLoader.getController();
                switch (keyEvent.getCode()) {
                    case DIGIT0:
                    case NUMPAD0:
                        controller.processDigit('0');
                        break;
                    case DIGIT1:
                    case NUMPAD1:
                        controller.processDigit('1');
                        break;
                    case DIGIT2:
                    case NUMPAD2:
                        controller.processDigit('2');
                        break;
                    case DIGIT3:
                    case NUMPAD3:
                        controller.processDigit('3');
                        break;
                    case DIGIT4:
                    case NUMPAD4:
                        controller.processDigit('4');
                        break;
                    case DIGIT5:
                    case NUMPAD5:
                        controller.processDigit('5');
                        break;
                    case DIGIT6:
                    case NUMPAD6:
                        controller.processDigit('6');
                        break;
                    case DIGIT7:
                    case NUMPAD7:
                        controller.processDigit('7');
                        break;
                    case DIGIT8:
                    case NUMPAD8:
                        controller.processDigit('8');
                        break;
                    case DIGIT9:
                    case NUMPAD9:
                        controller.processDigit('9');
                        break;
                    case BACK_SPACE:
                        controller.processBackspace();
                        break;
                    case DELETE:
                        controller.processAllClear();
                }

            }
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EnigmaCalculatorMain.class.getResource(fxml + ".fxml"));
        fLoader = fxmlLoader;
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}