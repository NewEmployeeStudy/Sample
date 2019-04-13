package application.control;

import java.sql.SQLException;

import application.Main;
import application.common.CommonUtil;
import application.common.ConstUtil;
import application.common.LogUtil;
import application.dao.Vmm001Dao;
import application.model.MCompanyModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/***
 * マスタメンテナンス画面コントローラ
 *
 * @author H.Isogai
 */
public class Vmm001Controller {

	// ログユーティリティ
	LogUtil log = new LogUtil();

	/// 会社情報
	// 銘柄コード
	@FXML
	private TextField txtStockCd;
	// 新証券コード
	@FXML
	private TextField txtBillCd;
	// ISINコード
	@FXML
	private TextField txtIsinCd;
	// 企業名
	@FXML
	private TextField txtCompanyName;
	// 設立年月日
	@FXML
	private DatePicker dpFoundationDate;
	// 上場市場先
	@FXML
	private ComboBox<ConstUtil.eListMarketCd> cboListedMarket;
	// 上場年月日
	@FXML
	private DatePicker dpListedDate;
	// 更新ボタン
	@FXML
	private Button btnRegist;
	// 戻るボタン
	@FXML
	private Button btnBack;

	/***
	 * 会社マスタ更新処理
	 * @param e
	 * @throws SQLException
	 */
	@FXML
	public void onActionRegist(ActionEvent e) throws SQLException {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		// 画面情報を同封し、Daoを呼び出す
		MCompanyModel mCompany = new MCompanyModel();
		mCompany.setStockCd(txtStockCd.getText());						// 銘柄コード
		mCompany.setBillCd(txtBillCd.getText());						// 新銘柄コード
		mCompany.setIsinCd(txtIsinCd.getText());						// ISINコード
		mCompany.setCompanyName(txtCompanyName.getText());				// 企業名
		mCompany.setFoundationDate(dpFoundationDate.getPromptText());	// 設立年月日
		mCompany.setListedMarketCd(cboListedMarket.getId());			// 上場市場コード
		mCompany.setListedDate(dpListedDate.getPromptText());			// 上場年月日
		// 画面情報の更新
		Vmm001Dao.regist(mCompany);
	}

	/***
	 * 戻るボタン押下処理
	 */
	@FXML
	public void onActionBack(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		// メニューへ戻る
		new Main().changeView("view/VMT001.fxml");
	}
}
