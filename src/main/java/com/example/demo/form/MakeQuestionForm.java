package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Data
public class MakeQuestionForm {

	/** 問題ID */
	@Length(min = 4, max = 20)
	private String questionId;

	/** 問題タイトル */
	@Length(min = 1, max = 255)
	private String questionTitle;
	
	/** 問題文 */
	@Length(min = 1, max = 1000)
	private String questionScript;
	
	/** 選択肢1 */
	@Length(min = 1, max = 1000)
	private String answerFirst;
	
	/** 選択肢2 */
	@Length(min = 1, max = 1000)
	private String answerSecond;
	
	/** 選択肢3 */
	@Length(min = 1, max = 1000)
	private String answerThird;
	
	/** 選択肢4 */
	@Length(min = 1, max = 1000)
	private String answerFourth;
	
	/** 答え */
	@Length(min = 1, max = 1000)
	private String questionAnswer;
}
