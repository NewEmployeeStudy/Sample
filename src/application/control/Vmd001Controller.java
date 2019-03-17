package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.common.CommonUtil;
import application.common.LogUtil;
import application.model.TSecuritiesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/***
 * 詳細画面コントローラ
 *
 * @author H.Isogai
 */
public class Vmd001Controller implements Initializable {

	// ログユーティリティー
	LogUtil log = new LogUtil();

	// 企業情報詳細
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

	/***
	 * 初期化
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

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
}
