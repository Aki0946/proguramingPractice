package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス
 * 
 * @author ys-fj
 *
 */
public class AppUtil {

	/**
	 * メッセージIDから、プロパティファイルに定義されているメッセージを取得する。
	 * 
	 * <p>取得したメッセージ内で置換が必要な箇所がある場合は<br>
	 * 引数の置換文字群を使って置換を行う
	 * 
	 * @param messageSource メッセージソース
	 * @param key メッセージキー
	 * @param params 置換文字群
	 * @return　プロパティファイルから取得したメッセージ
	 */
	public static String getMessage(MessageSource messageSource, String key, Object... params) {
		return messageSource.getMessage(key, params, Locale.JAPAN);
	}
	
	/**
	 * DBのLIKE検索用に、パラメーターにワイルドカードを付与します。
	 * 
	 * @param param パラメーター
	 * @return 前後にワイルドカードがついたパラメーター
	 */
	public static String addWildcard(String param) {
		return "%" + param + "%";
	}
	
	/**
	 * リダイレクト先のURLを受け取って、リダイレクトURLを作成します。
	 * 
	 * @param url リダイレクト先URL
	 * @return リダイレクトのURL
	 */
	public static String doRedirect(String url) {
		return "redirect:" + url;
	}

}
