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
    private ProjectileService projectileService = new ProjectileService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Circle circle = new Circle();
        circle.setFill(Color.BLACK);
        circle.setRadius(25);
        root.getChildren().add(circle);
        AnchorPane.setBottomAnchor(circle, 0.0);
        AnchorPane.setLeftAnchor(circle, 0.0);

        projectileService.createTask();


        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);

        // Service de projectile
        projectileService.start();
        projectileService.setOnSucceeded(event -> {
            ProjectileService.Etat etat = (ProjectileService.Etat) projectileService.getLastValue();
            if (etat != null) {
                AnchorPane.setLeftAnchor(circle, etat.getX());
                AnchorPane.setBottomAnchor(circle, etat.getY());
            }
        });

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
