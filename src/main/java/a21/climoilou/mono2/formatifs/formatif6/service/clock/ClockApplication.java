package a21.climoilou.mono2.formatifs.formatif6.service.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ClockApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label root = new Label("00:00:00");
        root.setPrefWidth(150);
        root.setAlignment(Pos.CENTER);
        startClock(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        primaryStage.show();
    }

    private void startClock(Label clockLabel) {
        ClockService clockService = new ClockService();
        clockService.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd :-) HH:mm:ss");
                String text = newValue.format(formatter);
                clockLabel.setText(text);
            }
        });
        clockService.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
