package a21.climoilou.mono2.formatifs.formatif6.service.uiAnimation;

import a21.climoilou.mono2.formatifs.formatif6.service.flasher.FlasherAnimationService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UiAnimationApplication extends Application {

    WindowAnimationService animationService = new WindowAnimationService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        root.setPrefWidth(720);
        root.setAlignment(Pos.CENTER);

        Button bouton = new Button("Va et ne reviens plus !");
        TextField xTextField = new TextField("200");
        TextField yTextField = new TextField("200");
        TextField largeurTextField = new TextField("200");
        TextField longueurTextField = new TextField("200");

        //service
        animationService.setPeriod(Duration.minutes(0.001));
        bouton.setOnAction(event -> {
            animationService.setActuelle(primaryStage.getX(), primaryStage.getY(), primaryStage.getWidth(), primaryStage.getHeight());
            animationService.setSouhaitee(stringEnDouble(xTextField), stringEnDouble(yTextField), stringEnDouble(largeurTextField), stringEnDouble(longueurTextField));
            animationService.restart();
        });

        animationService.setOnSucceeded(event -> {
            WindowAnimationService.LocationTaille valueTemp = (WindowAnimationService.LocationTaille) animationService.getLastValue();
            if (valueTemp != null) {
                primaryStage.setX(valueTemp.getX());
                primaryStage.setY(valueTemp.getY());
                primaryStage.setWidth(valueTemp.getLargeur());
                primaryStage.setHeight(valueTemp.getLongueur());
            }
        });

        root.getChildren().addAll(bouton, xTextField, yTextField, largeurTextField, longueurTextField);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public Double stringEnDouble(TextField textField) {
        return Double.valueOf(textField.getText());
    }


    public static void main(String[] args) {
        launch();
    }
}
