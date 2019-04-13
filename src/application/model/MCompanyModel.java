package application.model;

/***
 * 会社マスタエンティティクラス
 *
 * @author H.Isogai
 */
public class MCompanyModel {

	/* 銘柄コード */
	private String stockCd;
	/* 新証券コード */
	private String billCd;
	/* ISINコード */
	private String isinCd;
	/* 企業名 */
	private String companyName;
	/* 設立年月日 */
	private String foundationDate;
	/* 上場市場先コード */
	private String listedMarketCd;
	/* 上場年月日 */
	private String listedDate;

	/***
	 * 会社マスタエンティティクラスコンストラクタ
	 */
	public MCompanyModel() {
	}

	public String getStockCd() {
		return stockCd;
	}

	public void setStockCd(String stockCd) {
		this.stockCd = stockCd;
	}

	public String getBillCd() {
		return billCd;
	}

	public void setBillCd(String billCd) {
		this.billCd = billCd;
	}

	public String getIsinCd() {
		return isinCd;
	}

	public void setIsinCd(String isinCd) {
		this.isinCd = isinCd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(String foundationDate) {
		this.foundationDate = foundationDate;
	}

	public String getListedMarketCd() {
		return listedMarketCd;
	}

	public void setListedMarketCd(String listedMarketCd) {
		this.listedMarketCd = listedMarketCd;
	}

	public String getListedDate() {
		return listedDate;
	}

	public void setListedDate(String listedDate) {
		this.listedDate = listedDate;
	}

}
