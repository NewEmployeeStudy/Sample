/***
 * メインメニューコントローラー
 */
package application.control;

import application.common.LogUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Vmt001Controller {

	// ログユーティリティー
	LogUtil log = new LogUtil();

	// 検索ボタン
	@FXML
	private Button btnVms001;
	// 詳細ボタン
	@FXML
	private Button btnVmd001;
	// メンテナンスボタン
	@FXML
	private Button btnVmm001;
	// データ取り込みボタン
	@FXML
	private Button btnVmg001;

	/***
	 * 検索ボタン押下時の遷移
	 */
	@FXML
	public void onActionVms001(ActionEvent e) {

	}

	/***
	 * 詳細ボタン押下時の遷移
	 */
	@FXML
	public void onActionVmd001(ActionEvent e) {

	}
}
