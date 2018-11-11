package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stage) {
		try {
			Main.stage = stage;
			changeView("Sample.fxml");
			Main.stage.show();
			//			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			//			Scene scene = new Scene(root,400,400);
			//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//			primaryStage.setScene(scene);
			//			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

    public void changeView(String fxml) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
        } catch (IOException e) {
			e.printStackTrace();
        }
    }
}
