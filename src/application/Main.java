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
			Main.stage.setTitle("大学発ベンチャー関連管理システム");
			changeView("view/VMT001.fxml");
			Main.stage.show();
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

	public void close() {
		stage.close();
	}
}
