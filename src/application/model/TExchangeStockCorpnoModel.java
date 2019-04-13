package application.model;

/***
 * 銘柄コード法人番号対応エンティティクラス
 *
 * @author H.Isogai
 *
 */
public class TExchangeStockCorpnoModel {

	/* 銘柄コード */
	private String stockCd;
	/* 法人番号 */
	private int corporateNo;
	/* 会社名 */
	private String corporateName;

	/***
	 * 銘柄コード法人番号対応エンティティクラスコンストラクタ
	 */
	public TExchangeStockCorpnoModel() {
	}

	/***
	 * 銘柄コード法人番号対応エンティティクラスコンストラクタ
	 */
	public TExchangeStockCorpnoModel(String stockCd, int corporateNo, String corporateName) {
		this.stockCd = stockCd;
		this.corporateNo = corporateNo;
		this.corporateName = corporateName;
	}

	public String getStockCd() {
		return stockCd;
	}

	public void setStockCd(String stockCd) {
		this.stockCd = stockCd;
	}

	public int getCorporateNo() {
		return corporateNo;
	}

	public void setCorporateNo(int corporateNo) {
		this.corporateNo = corporateNo;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

}
