package com.example.demo.constant;

/**
 * URL 定数クラス
 * 
 * @author ys-fj
 *
 */
public class UrlConst {

	/** ログイン画面 */
	public static final String LOGIN = "/login";

	/** ユーザー登録画面 */
	public static final String SIGNUP = "/signup";

	/** メニュー画面 */
	public static final String MENU = "/menu";
	
	/** ユーザー一覧画面 */
	public static final String USER_LIST = "/userList";
	
	/** ユーザー編集画面 */
	public static final String USER_EDIT = "/userEdit";
	
	/** 問題制作画面 */
	public static final String MAKE_QUESTION = "/makeQuestion";
	
	/** 問題プレイ画面 */
	public static final String PLAY_QUESTION = "/playQuestion";
	
	/** 問題一覧画面 */
	public static final String QUESTION_LIST = "/questionList";

	/** 認証不要画面 */
	public static final String[] NO_AUTHENTICATION = { LOGIN, SIGNUP, "/webjars/**", "/css/**" };
}
