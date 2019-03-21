package application.control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

import application.Main;
import application.common.CommonUtil;
import application.common.ConstUtil;
import application.common.LogUtil;
import application.dao.Vmd001Dao;
import application.model.MCompanyModel;
import application.model.TExchangeStockCorpnoModel;
import application.model.TSecuritiesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/***
 * 詳細画面コントローラ
 *
 * @author H.Isogai
 */
public class Vmd001Controller implements Initializable {

	// ログユーティリティ
	LogUtil log = new LogUtil();

	/// 会社情報
	// 会社名
	@FXML
	private TextField txtCompanyName;
	// 銘柄コード
	@FXML
	private TextField txtStockCd;
	// 法人番号
	@FXML
	private TextField txtCorporateNo;
	// 設立年月日
	@FXML
	private TextField txtFoundationDate;
	// 上場先市場
	@FXML
	private TextField txtListedMarket;
	/// 企業情報詳細
	@FXML
	private TableView<TSecuritiesModel> tvCompanyDetail;
	// 事項日付(From)
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColArticleDateFr;
	// 事項日付(To)
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColArticleDateTo;
	// 発行済株式総数増減額
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColAllIssuedStockTerms;
	// 発行済株式総数残高
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColAllIssuedStockBalance;
	// 資本金増減額
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColCapitalTerms;
	// 資本金残高
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColCapitalBalance;
	// 資本準備金増減額
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColLegalCapitalSurplusTerms;
	// 資本準備金残高
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColLegalCapitalSurplusBalance;
	// 総調達額
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColAmountOfContent;
	// 株価
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColStockPrice;
	// 企業情報
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColEnterpriseValue;
	// 割当先等
	@FXML
	private TableColumn<TSecuritiesModel, String> tblColAllotment;

	// TableViewへ格納するためのオブジェクト
	private ObservableList<TSecuritiesModel> olData;

	@FXML
	public void onLoadfrmDetail(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		try {
			this.initialize();

			String strStockCd = null;

			/// 詳細情報DAO
			// 会社情報
			MCompanyModel mCompany = Vmd001Dao.getHeader(strStockCd);
			txtCompanyName.setText(mCompany.getCompanyName());
			txtStockCd.setText(mCompany.getStockCd());
			txtFoundationDate.setText(mCompany.getFoundationDate());
			// 上場市場名へ変換
			txtListedMarket.setText(ConstUtil.eListMarketCd.valueOf(mCompany.getListedMarketCd()).getName());
			TExchangeStockCorpnoModel tExchange = Vmd001Dao.getHeader(mCompany);
			txtCorporateNo.setText(String.valueOf(tExchange.getCorporateNo()));

			// 財務情報
			for (TSecuritiesModel tSec : Vmd001Dao.getList(strStockCd)) {
				olData.addAll(tSec);
			}
		} catch (Exception ex) {
			log.log(Level.SEVERE, "エラーが発生しました。", ex);
		}
	}

	/***
	 * 戻るボタン押下処理
	 */
	@FXML
	public void onActionBack(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		// メニューへ戻る
		new Main().changeView("view/VMS001.fxml");
	}

	/***
	 * 初期化
	 */
	public void initialize() {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		/// 財務情報
		// FX用ArrayList
		olData = FXCollections.observableArrayList();

		// TableViewへ設定
		tvCompanyDetail.itemsProperty().setValue(olData);
		tvCompanyDetail.setItems(olData);

		// CellFactoryの生成
		tblColArticleDateFr.setCellValueFactory(new PropertyValueFactory<>("articleDateFr"));
		tblColArticleDateTo.setCellValueFactory(new PropertyValueFactory<>("articleDateTo"));
		tblColAllIssuedStockTerms.setCellValueFactory(new PropertyValueFactory<>("allIssuedStockTerms"));
		tblColAllIssuedStockBalance.setCellValueFactory(new PropertyValueFactory<>("allIssuedStockBalance"));
		tblColCapitalTerms.setCellValueFactory(new PropertyValueFactory<>("capitalTerms"));
		tblColCapitalBalance.setCellValueFactory(new PropertyValueFactory<>("capitalBalance"));
		tblColLegalCapitalSurplusTerms.setCellValueFactory(new PropertyValueFactory<>("legalCapitalSurplusTerms"));
		tblColLegalCapitalSurplusBalance.setCellValueFactory(new PropertyValueFactory<>("legalCapitalSurplusBalance"));
		tblColAmountOfContent.setCellValueFactory(new PropertyValueFactory<>("amountOfContent"));
		tblColStockPrice.setCellValueFactory(new PropertyValueFactory<>("stockPrice"));
		tblColEnterpriseValue.setCellValueFactory(new PropertyValueFactory<>("enterpriseValue"));
		tblColAllotment.setCellValueFactory(new PropertyValueFactory<>("allotment"));
	}

	/***
	 * 初期化
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.initialize();
	}
}
