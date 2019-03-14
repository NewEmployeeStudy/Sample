package application.control;

import java.util.List;
import java.util.logging.Level;

import application.Main;
import application.common.LogUtil;
import application.dao.SampleDao;
import application.model.Sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController3 implements Initializable {

	LogUtil log = new LogUtil();

	@FXML
	private Button searchBtn;
	@FXML
	private Button backBtn;
	@FXML
	private Label label01;
	@FXML
	private TextField id;
	@FXML
	private TableView table01;
	@FXML
	private TableColumn idCol;
	@FXML
	private TableColumn passCol;
	@FXML
	private TableColumn nameCol;

	private ObservableList<Sample> data;

	@FXML
	public void onClickSearchBtn(ActionEvent e) {
		log.log("SampleController3.onClickSearchBtn");
		try {
			this.initialize();
			SampleDao dao = new SampleDao();
			List<Sample> lst = dao.find(id.getText());
			for (Sample sam : lst) {
				data.addAll(sam);
			}
		} catch (Exception ex) {
			log.log(Level.SEVERE, "エラーが発生しました。", ex);
		}
	}

	@FXML
	public void onClickBackBtn(ActionEvent e) {
		log.log("SampleController3.onClickBackBtn");
		new Main().changeView("Sample.fxml");
	}

	public void initialize() {
		data = FXCollections.observableArrayList();
		table01.itemsProperty().setValue(data);
		table01.setItems(data);
		idCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("id"));
		passCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("pass"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("name"));
	}

	@Override
	public void initialize(java.net.URL url, java.util.ResourceBundle bundle) {
		data = FXCollections.observableArrayList();
		table01.itemsProperty().setValue(data);
		table01.setItems(data);
		idCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("id"));
		passCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("pass"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Sample, String>("name"));
	}
}
