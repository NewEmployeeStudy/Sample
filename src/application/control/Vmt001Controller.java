package application.control;

import application.Main;
import application.common.CommonUtil;
import application.common.LogUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/***
 * メインメニューコントローラ
 *
 * @author H.Isogai
 */
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
	// 閉じるボタン
	@FXML
	private Button btnClose;

	/***
	 * 検索ボタン押下時の遷移
	 */
	@FXML
	public void onActionVms001(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMS001.fxml");
	}

	/***
	 * 詳細ボタン押下時の遷移
	 */
	@FXML
	public void onActionVmd001(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMD001.fxml");
	}

	/***
	 * メンテナンスボタン押下時の遷移
	 */
	@FXML
	public void onActionVmm001(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMM001.fxml");
	}

	/***
	 * データ取り込みボタン押下時の遷移
	 */
	@FXML
	public void onActionVmg001(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMG001.fxml");
	}

	/***
	 * 閉じるボタン押下時の動作
	 */
	@FXML
	public void onClickCloseBtn(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().close();
	}
}
