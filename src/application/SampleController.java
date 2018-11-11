package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

	@FXML
	private Button btn01;
	@FXML
	private Button btn02;
	@FXML
	public void onClckBtn01(ActionEvent e) {
		new Main().changeView("Sample2.fxml");
	}
	@FXML
	public void onClckBtn02(ActionEvent e) {
		new Main().changeView("Sample3.fxml");
	}

}
