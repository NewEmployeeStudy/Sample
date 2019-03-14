package application.control;

import application.Main;
import application.common.LogUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

	LogUtil log = new LogUtil();

	@FXML
	private Button btn01;
	@FXML
	private Button btn02;
	@FXML
	private Button btn03;

	@FXML
	public void onClckBtn01(ActionEvent e) {
		log.log("SampleController.onClckBtn01");
		new Main().changeView("Sample2.fxml");
	}

	@FXML
	public void onClckBtn02(ActionEvent e) {
		log.log("SampleController.onClckBtn02");
		new Main().changeView("Sample3.fxml");
	}

	@FXML
	public void onClckBtn03(ActionEvent e) {
		log.log("SampleController.onClckBtn03");
		new Main().changeView("Sample4.fxml");
	}
}
