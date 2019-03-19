package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.MCompanyModel;
import application.model.TSecuritiesModel;

/***
 * 詳細画面Daoクラス
 *
 * @author H.Isoagi
 */
public class Vmd001Dao {

	// ResourceBundle
	static ResourceBundle rb = null;
	// Connection オブジェクト
	static Connection conn = null;
	// PreparedStatement オブジェクト
	static PreparedStatement preStat = null;

	/***
	 * 詳細画面Daoクラスシングルトンインスタンス
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Vmd001Dao() throws ClassNotFoundException, SQLException {
		// リソースファイルの読み込み
		rb = ResourceBundle.getBundle("java");

		// JDBCへの接続
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(rb.getString("JDBC"));
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
	}

	/***
	 * 画面表示ヘッダ情報
	 * @param stockCd 銘柄コード
	 * @return MCompanyModel 会社マスタ
	 * @throws SQLException
	 */
	public static MCompanyModel getHeader(String stockCd) throws SQLException {

		// SQLの組み立て
		StringBuilder sbSQLStmt = new StringBuilder();

		sbSQLStmt.append("SELECT * FROM M_COMPANY ");
		sbSQLStmt.append("WHERE STOCKCD = ? ");

		preStat = conn.prepareStatement(sbSQLStmt.toString());
		preStat.setString(1, stockCd);

		// SQLの実行
		ResultSet rs = preStat.executeQuery();

		// レコードが存在していれば、会社マスタエンティティクラスにデータを格納
		MCompanyModel mCompany = new MCompanyModel();
		if(rs.next()) {
			mCompany.setStockCd(rs.getString("STOCKCD"));				// 銘柄コード
			mCompany.setBillCd(rs.getString("BILLCD"));					// 新証券コード
			mCompany.setIsinCd(rs.getString("ISINCD"));					// ISINコード
			mCompany.setCompanyName(rs.getString("COMPANYNAME"));		// 企業名
			mCompany.setFoundationDate(rs.getString("FOUNDATIONDATE"));	// 設立年月日
			mCompany.setListedMarketCd(rs.getString("LISTEDMARKETCD"));	// 上場市場先コード
			mCompany.setListedDate(rs.getString("LISTEDDATE"));			// 上場年月日
		}

		// ResultSet オブジェクトのクローズ
		if(rs != null) {
			rs.close();
		}

		// PreparedStatement オブジェクトのクローズ
		if(preStat != null) {
			preStat.close();
		}

		return mCompany;
	}

	/***
	 * 画面表示リスト情報
	 * @param stockCd 銘柄コード
	 * @return List<TSecuritiesModel> 財務情報リスト
	 * @throws SQLException
	 */
	public static List<TSecuritiesModel> getList(String stockCd) throws SQLException {

		List<TSecuritiesModel> tSecuritiesList = new LinkedList<>();

		// SQLの組み立て
		StringBuilder sbSQLStmt = new StringBuilder();

		sbSQLStmt.append("SELECT * FROM T_SECURITIES ");
		sbSQLStmt.append("WHERE STOCEED = ? ");

		preStat = conn.prepareStatement(sbSQLStmt.toString());
		preStat.setString(1,  stockCd);

		// SQLの実行
		ResultSet rs = preStat.executeQuery();

		// レコードが存在する間、財務情報リストエンティティクラスにデータを格納
		while(rs.next()) {
			TSecuritiesModel tSecurities = new TSecuritiesModel();

			tSecurities.setStockCd(rs.getString("STOCKCD"));
			tSecurities.setBillCd(rs.getString("BILLCD"));
			tSecurities.setIsinCd(rs.getString("ISINCD"));
			tSecurities.setArticleDateFr(rs.getString("ARTICLEDATEFR"));
			tSecurities.setArticleDateTo(rs.getString("ARTICLEDATETO"));
			tSecurities.setAllIssuedStockTerms(rs.getString("ALLISSUEDSTOCKTERMS"));
			tSecurities.setAllIssuedStockBalance(rs.getString("ALLISSUESTOCKBALANCE"));
			tSecurities.setCapitalTerms(rs.getString("CAPITALTERMS"));
			tSecurities.setCapitalBalance(rs.getString("CAPITALBALANCE"));
			tSecurities.setLegalCapitalSurplusTerms(rs.getString("LEGALCAPITALSURPLUSTERMS"));
			tSecurities.setLegalCapitalSurplusBalance(rs.getString("LEGALCAPITALSURPLUSBALANCE"));
			tSecurities.setAmountOfContent(rs.getString("AMOUNTOFCONTENT"));
			tSecurities.setStockPrice(rs.getString("STOCKPRICE"));
			tSecurities.setEnterpriseValue(rs.getString("ENTERPRISEVALUE"));
			tSecurities.setAllotment(rs.getString("ALLOTMENT"));
			// LinkedListの要素に追加
			tSecuritiesList.add(tSecurities);
		}

		// ResultSet オブジェクトのクローズ
		if(rs != null) {
			rs.close();
		}

		// PreparedStatement オブジェクトのクローズ
		if(preStat != null) {
			preStat.close();
		}

		return tSecuritiesList;
	}
}
