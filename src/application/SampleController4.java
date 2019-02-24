package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import application.dao.SampleDao;
import application.model.Sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController4 {

	Stage stage;
	@FXML
	private Button selectBtn;
	@FXML
	private Button backBtn;
	@FXML
	private Button execBtn;
	@FXML
	private Label label01;
	@FXML
	private TextField file;

	@FXML
	public void onClickSelectBtn(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("ファイル選択");
		fileChooser.setInitialDirectory(new File("../"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSVファイル", "*.csv"));
		File file = fileChooser.showOpenDialog(this.stage);
		if (file != null) {
			String filename = file.getPath().toString();
			this.file.setText(filename);
		}
	}

	@FXML
	public void onClickExecBtn(ActionEvent e) {
		try {
			File f = new File(this.file.getText());
			BufferedReader br = new BufferedReader(new FileReader(f));
			SampleDao dao = new SampleDao();

			String line;
			// 1行ずつCSVファイルを読み込む
			while ((line = br.readLine()) != null) {
				Sample sample = new Sample();
				String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
				sample.setId(data[0]);
				sample.setPass(data[1]);
				sample.setName(data[2]);
				dao.insert(sample);

			}
			br.close();

		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	@FXML
	public void onClickBackBtn(ActionEvent e) {
		new Main().changeView("Sample.fxml");
	}

}