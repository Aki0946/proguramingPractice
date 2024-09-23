package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "question_info")
@Data
@AllArgsConstructor
public class QuestionInfo {

	/** 問題ID */
	@Id
	@Column(name = "question_id")
	private String questionId;

	/** 問題タイトル */
	@Column(name = "question_title")
	private String questionTitle;
	
	/** 問題文 */
	@Column(name = "question_script")
	private String questionScript;
	
	/** 選択肢1 */
	@Column(name = "answer_first")
	private String answerFirst;
	
	/** 選択肢2 */
	@Column(name = "answer_second")
	private String answerSecond;
	
	/** 選択肢3 */
	@Column(name = "answer_third")
	private String answerThird;
	
	/** 選択肢4 */
	@Column(name = "answer_fourth")
	private String answerFourth;

	/** 答え */
	@Column(name = "question_answer")
	private String questionAnswer;
	

	public QuestionInfo() {
	}

}
