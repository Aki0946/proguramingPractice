package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * 問題一覧画面Formクラス
 * 
 * @author takke
 * 
 */
@Data
public class QuestionListForm {
	
	/** 問題ID */
	@Length(min = 4, max = 20)
	private String questionId;
	
	/** 問題タイトル */
	@Length(min = 1, max = 255)
	private String questionTitle;
	
	/** 問題一覧情報から選択された問題ID */
	private String selectedQuestionId;
	
	/**
	 * 問題一覧情報から選択された問題IDをクリアします。
	 * 
	 * @return ユーザー一覧情報から選択された問題IDクリア後のインスタンス
	 */
	public QuestionListForm clearSelectedQuestionId() {
		this.selectedQuestionId = null;
		
		return this;
	}

}
