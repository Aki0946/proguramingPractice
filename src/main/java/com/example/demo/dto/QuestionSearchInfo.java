package com.example.demo.dto;



import lombok.Data;

/**
 * ユーザー一覧画面検索用DTOクラス
 * 
 * @author takke
 */
@Data
public class QuestionSearchInfo {
	
	/** 問題ID */
	private String questionId;
	
	/** 問題タイトル */
	private String questionTitle;
	
	
}