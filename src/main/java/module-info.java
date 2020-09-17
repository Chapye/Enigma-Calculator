module enigma {
    requires javafx.controls;
    requires javafx.fxml;

    opens enigma to javafx.fxml;
    exports enigma;
}