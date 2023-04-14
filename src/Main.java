import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("res/session.fxml"))));

        primaryStage.setScene(scene);
        primaryStage.setHeight(675);
        primaryStage.setWidth(753);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

}