package application.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Optional;
import java.util.logging.Level;

import application.Main;
import application.common.CommonUtil;
import application.common.LogUtil;
import application.dao.SampleDao;
import application.model.Sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Vmg001Controller {

	LogUtil log = new LogUtil();

	Stage stage;
	@FXML
	private Button btnSelect;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnExec;
	@FXML
	private Label label01;
	@FXML
	private TextField path;

	/***
	 * 選択ボタン押下処理
	 */
	@FXML
	public void onClickSelectBtn(ActionEvent e) {

		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("ファイル選択");
		fileChooser.setInitialDirectory(new File("../"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSVファイル", "*.csv"));
		File file = fileChooser.showOpenDialog(this.stage);
		if (file != null) {
			String filename = file.getPath().toString();
			this.path.setText(filename);
		}
	}

	/***
	 * 取込ボタン押下処理
	 */
	@FXML
	public void onClickExecBtn(ActionEvent e) {

		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		Alert alrt = new Alert(AlertType.CONFIRMATION); //アラートを作成
		alrt.setContentText("取り込み処理を行います。よろしいですか？");
		Optional<ButtonType> result = alrt.showAndWait();
		if (result.get() == ButtonType.OK) { //OKボタンがクリックされたら
			try {
				File f = new File(this.path.getText());
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

				Alert alrt2 = new Alert(AlertType.INFORMATION); //アラートを作成
				alrt2.setContentText("取り込みが完了しました。");
				alrt2.showAndWait();

			} catch (Exception ex) {
				ex.printStackTrace();
				log.log(Level.SEVERE, "エラーが発生しました。", ex);
				Alert alrtE = new Alert(AlertType.ERROR); //アラートを作成
				alrtE.setContentText("取り込み処理が異常終了しました。");
				alrtE.showAndWait();

			}
		}
	}

	/***
	 * 戻るボタン押下処理
	 */
	@FXML
	public void onClickBackBtn(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMT001.fxml");
	}

}
