package be.infernalwhale;

import be.infernalwhale.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new MainView(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void start() {
        launch();
    }
}
