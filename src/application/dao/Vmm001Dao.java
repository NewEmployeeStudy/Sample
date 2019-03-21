package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.model.MCompanyModel;

public class Vmm001Dao {

	// ResourceBundle
	static ResourceBundle rb = null;
	// Connection オブジェクト
	static Connection conn = null;
	// PreparedStatement オブジェクト
	static PreparedStatement preStat = null;

	/***
	 * マスタメンテDaoクラスシングルトンインスタンス
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Vmm001Dao() throws ClassNotFoundException, SQLException {
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
	 * 会社マスタおよび銘柄コード法人番号対応テーブル更新処理
	 * @param mCompany 会社マスタエンティティクラス
	 * @throws SQLException
	 */
	public static void regist(MCompanyModel mCompany) throws SQLException {

		// SQLの組み立て
		StringBuilder sbSQLStmt = new StringBuilder();

		sbSQLStmt.append("INSERT OR REPLACE INTO M_COMPANY ");
		sbSQLStmt.append("(STOCKCD, BILLCD, ISINCD, COMPANYNAME, FOUNDATIONDATE, LISTEDMARKET, LISTEDDATE) ");
		sbSQLStmt.append("VALUES ");
		sbSQLStmt.append("(?, ?, ?, ?, ?, ?, ?) ");

		preStat = conn.prepareStatement(sbSQLStmt.toString());
		preStat.setString(1, mCompany.getStockCd());		// 銘柄コード
		preStat.setString(2, mCompany.getBillCd());			// 新証券コード
		preStat.setString(3, mCompany.getIsinCd());			// ISINコード
		preStat.setString(4, mCompany.getCompanyName());	// 企業名
		preStat.setString(5, mCompany.getFoundationDate());	// 設立年月日
		preStat.setString(6, mCompany.getListedMarketCd());	// 上場市場コード
		preStat.setString(7, mCompany.getListedDate());		// 上場年月日

		// SQLの実行
		preStat.executeUpdate();

		// SQLの組み立て
		sbSQLStmt = new StringBuilder();

		sbSQLStmt.append("INSERT OR REPLACE INTO T_EXCHANGESTOCKCORPNO ");
		sbSQLStmt.append("(STOCKCD, CORPORATENAME) ");
		sbSQLStmt.append("VALUES ");
		sbSQLStmt.append("(?, ?) ");

		preStat = conn.prepareStatement(sbSQLStmt.toString());
		preStat.setString(1, mCompany.getStockCd());
		preStat.setString(2, mCompany.getCompanyName());

		// SQLの実行
		preStat.executeUpdate();

		// 更新内容のコミット
		conn.commit();
	}

}
