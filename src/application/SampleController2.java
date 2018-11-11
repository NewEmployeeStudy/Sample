package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController2 {

	@FXML
	private Button okBtn;
	@FXML
	private Button backBtn;
	@FXML
	private Label dispFild;
	@FXML
	private TextField name;
	@FXML
	public void onClickOkBtn(ActionEvent e) {
		dispFild.setText("Hello " + name.getText());

	}
	@FXML
	public void onClickBackBtn(ActionEvent e) {
		new Main().changeView("Sample.fxml");
	}

}
