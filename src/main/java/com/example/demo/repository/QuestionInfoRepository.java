package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.QuestionInfo;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface QuestionInfoRepository extends JpaRepository<QuestionInfo, String> {
	
	/**
	 * 問題IDの部分一致検索を行います
	 * 
	 * @param questionTitle 問題ID
	 * @return 検索でヒットした問題情報のリスト
	 */
	List<QuestionInfo> findByQuestionTitleLike(String questionTitle);
	

}
