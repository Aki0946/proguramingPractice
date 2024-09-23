package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.QuestionListInfo;
import com.example.demo.dto.QuestionSearchInfo;

/**
 * ユーザー一覧画面Serviceクラス
 * 
 * @author takke
 * 
 */
public interface QuestionListService {
	
	/**
	 * 問題情報テーブルを全権検索し、ユーザー一覧画面に必要な情報へ変換して返却します。
	 * 
	 * @return 問題情報テーブルの全登録情報
	 */
	public List<QuestionListInfo> selectQuestionList();
	

	/**
	 * 問題情報を条件検索した結果を画面の表示用に変換して返却します。
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	public List<QuestionListInfo> selectQuestionListByParam(QuestionSearchInfo dto);
	
	
}
