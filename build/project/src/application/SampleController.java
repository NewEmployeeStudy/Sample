package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	private Button okBtn;
	@FXML
	private Label dispFild;
	@FXML
	private TextField name;
	@FXML
	public void onClckOkBtn(ActionEvent e) {
		dispFild.setText("Hello " + name.getText());

	}
}
