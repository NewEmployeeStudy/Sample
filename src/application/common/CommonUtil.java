package application.common;

/***
 * 共通ユーティリティクラス
 *
 * @author H.Isogai
 */
public class CommonUtil {

	/***
	 * 共通ユーティリティクラスシングルトンインスタンス
	 */
	private CommonUtil() {
	}

	/***
	 * 実行中のクラス名を取得
	 * @return
	 */
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}

	/***
	 * 実行中のメソッド名を取得
	 * @return
	 */
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	/***
	 * "の除去
	 * @param 対象文字列
	 */
	public static String deleteDoubleQuate(String str) {
		if (null == str) {
			return "";
		}
		return str.replace("\"", "");
	}
}
