package com.example.demo.dto;

import lombok.Data;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Data
public class QuestionListInfo {
	
	/** 問題Id */
	private String questionId;

	/** 問題タイトル */
	private String questionTitle;

}
