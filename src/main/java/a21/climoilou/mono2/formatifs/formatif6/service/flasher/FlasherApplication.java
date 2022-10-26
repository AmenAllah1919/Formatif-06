package a21.climoilou.mono2.formatifs.formatif6.service.flasher;

import a21.climoilou.mono2.formatifs.formatif6.service.clock.ClockService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.format.DateTimeFormatter;

public class FlasherApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPrefWidth(300);
        root.setAlignment(Pos.CENTER);

        Button bouton = new Button("Flash !");
        Rectangle rectangle = new Rectangle(100, 100, Color.BLACK);

        //service

        root.getChildren().addAll(bouton, rectangle);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}
