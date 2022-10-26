package a21.climoilou.mono2.formatifs.formatif6.service.projectile;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProjectileApplication extends Application {
    private ExecutorService service = Executors.newFixedThreadPool(20);

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();


        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);

        // Service de projectile






        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
