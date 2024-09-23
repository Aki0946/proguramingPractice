package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.QuestionInfo;
import com.example.demo.form.MakeQuestionForm;

/**
 * ユーザー登録画面 Serviceクラスインターフェース
 * 
 * @author ys-fj
 *
 */

public interface MakeQuestionService {
	
	/**
	 * 画面の入力情報をもとに問題情報テーブルの新規登録を行います。
	 * 
	 * <p>ただし、以下のテーブル項目はこの限りではありません。
	 * <ul>
	 * </ul>
	 * 
	 * @param form 入力情報
	 * @return 登録情報(問題情報Entity)、すでに同じ問題IDで登録がある場合はEmpty
	 */
	public Optional<QuestionInfo> resistQuestionInfo(MakeQuestionForm form);

}
