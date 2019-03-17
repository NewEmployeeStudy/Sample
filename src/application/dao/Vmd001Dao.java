package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	ResourceBundle rb = null;
	// Connection オブジェクト
	Connection conn = null;
	// PreparedStatement オブジェクト
	PreparedStatement preStat = null;

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
	public MCompanyModel getHeader(String stockCd) throws SQLException {

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
		return mCompany;
	}

	/***
	 * 画面表示リスト情報
	 * @param stockCd 銘柄コード
	 * @return List<TSecuritiesModel> 財務情報リスト
	 */
	public List<TSecuritiesModel> getList(String stockCd) {
		return null;
	}
}
