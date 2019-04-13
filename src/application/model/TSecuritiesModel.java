package application.model;

/***
 * 有価証券情報エンティティクラス
 *
 * @author H.Isogai
 *
 */
public class TSecuritiesModel {

	/* 銘柄コード */
	private String stockCd;
	/* 新証券コード */
	private String billCd;
	/* ISINコード */
	private String isinCd;
	/* 事項日付(From) */
	private String articleDateFr;
	/* 事項日付(To) */
	private String articleDateTo;
	/* 発行済株式総数増減額 */
	private String allIssuedStockTerms;
	/* 発行済株式総数残高 */
	private String allIssuedStockBalance;
	/* 資本金増減額 */
	private String capitalTerms;
	/* 資本金残高 */
	private String capitalBalance;
	/* 資本準備金増減額 */
	private String legalCapitalSurplusTerms;
	/* 資本準備金残高 */
	private String legalCapitalSurplusBalance;
	/* 総調達額 */
	private String amountOfContent;
	/* 株価 */
	private String stockPrice;
	/* 企業情報 */
	private String enterpriseValue;
	/* 割当先等 */
	private String allotment;

	/***
	 * 有価証券情報エンティティクラスコンストラクタ
	 */
	public TSecuritiesModel() {
	}

	/***
	 * 有価証券情報エンティティクラスコンストラクタ
	 */
	public TSecuritiesModel(String stockCd, String billCd, String isinCd,
							String articleDateFr, String articleDateTo,
							String allIssuedStockTerms, String allIssuedStockBalance,
							String capitalTerms, String capitalBalance,
							String legalCapitalSurplusTerms, String legalCapitalSurplusBalance,
							String amountOfContent, String stockPrice,
							String enterpriseValue, String allotment) {
		this.stockCd = stockCd;
		this.billCd = billCd;
		this.isinCd = isinCd;
		this.articleDateFr = articleDateFr;
		this.articleDateTo = articleDateTo;
		this.allIssuedStockTerms = allIssuedStockTerms;
		this.allIssuedStockBalance = allIssuedStockBalance;
		this.capitalTerms = capitalTerms;
		this.capitalBalance = capitalBalance;
		this.legalCapitalSurplusTerms = legalCapitalSurplusTerms;
		this.legalCapitalSurplusBalance = legalCapitalSurplusBalance;
		this.amountOfContent = amountOfContent;
		this.stockPrice = stockPrice;
		this.enterpriseValue = enterpriseValue;
		this.allotment = allotment;
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

	public String getArticleDateFr() {
		return articleDateFr;
	}

	public void setArticleDateFr(String articleDateFr) {
		this.articleDateFr = articleDateFr;
	}

	public String getArticleDateTo() {
		return articleDateTo;
	}

	public void setArticleDateTo(String articleDateTo) {
		this.articleDateTo = articleDateTo;
	}

	public String getAllIssuedStockTerms() {
		return allIssuedStockTerms;
	}

	public void setAllIssuedStockTerms(String allIssuedStockTerms) {
		this.allIssuedStockTerms = allIssuedStockTerms;
	}

	public String getAllIssuedStockBalance() {
		return allIssuedStockBalance;
	}

	public void setAllIssuedStockBalance(String allIssuedStockBalance) {
		this.allIssuedStockBalance = allIssuedStockBalance;
	}

	public String getCapitalTerms() {
		return capitalTerms;
	}

	public void setCapitalTerms(String capitalTerms) {
		this.capitalTerms = capitalTerms;
	}

	public String getCapitalBalance() {
		return capitalBalance;
	}

	public void setCapitalBalance(String capitalBalance) {
		this.capitalBalance = capitalBalance;
	}

	public String getLegalCapitalSurplusTerms() {
		return legalCapitalSurplusTerms;
	}

	public void setLegalCapitalSurplusTerms(String legalCapitalSurplusTerms) {
		this.legalCapitalSurplusTerms = legalCapitalSurplusTerms;
	}

	public String getLegalCapitalSurplusBalance() {
		return legalCapitalSurplusBalance;
	}

	public void setLegalCapitalSurplusBalance(String legalCapitalSurplusBalance) {
		this.legalCapitalSurplusBalance = legalCapitalSurplusBalance;
	}

	public String getAmountOfContent() {
		return amountOfContent;
	}

	public void setAmountOfContent(String amountOfContent) {
		this.amountOfContent = amountOfContent;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getEnterpriseValue() {
		return enterpriseValue;
	}

	public void setEnterpriseValue(String enterpriseValue) {
		this.enterpriseValue = enterpriseValue;
	}

	public String getAllotment() {
		return allotment;
	}

	public void setAllotment(String allotment) {
		this.allotment = allotment;
	}

}
