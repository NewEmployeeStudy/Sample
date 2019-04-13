package application.common;

/***
 * 定数ユーティリティクラス
 *
 * @author H.Isogai
 */
public class ConstUtil {

	/***
	 * 定数ユーティリティクラスシングルトンインスタンス
	 */
	private ConstUtil() {
	}

	/***
	 * 上場市場コード
	 * @author H.Isogai
	 */
	public enum eListMarketCd {
		TOKYO1("01", "東証１部"),
		TOKYO2("02", "東証２部"),
		MOTHERS("03", "マザーズ"),
		JASDAQ("04", "ジャスダック"),
		NAGOYA1("05", "名証１部"),
		NAGOYA2("06", "名証２部"),
		CENTREX("07", "セントレックス"),
		GR_SAPPORO("08", "本則(札幌)"),
		AMBITIOUS("09", "アンビシャス"),
		GR_FUKUOKA("10", "本則(福岡)"),
		QBOARD("11", "Q-BOARD");

		private final String code;
		private final String name;

		/***
		 * 上場市場コード列挙型コンストラクタ
		 * @param code
		 * @param name
		 */
		private eListMarketCd(final String code, final String name) {
			this.code = code;
			this.name= name;
		}

		/***
		 * 上場市場コードを取得
		 * @return
		 */
		public String getCode() {
			return code;
		}

		/***
		 * 上場市場名称を取得
		 * @return
		 */
		public String getName() {
			return name;
		}
	}
}
