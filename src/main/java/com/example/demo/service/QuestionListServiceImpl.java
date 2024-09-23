package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.QuestionListInfo;
import com.example.demo.dto.QuestionSearchInfo;
import com.example.demo.entity.QuestionInfo;
import com.example.demo.repository.QuestionInfoRepository;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * 問題一覧画面Service実装クラス
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class QuestionListServiceImpl implements QuestionListService{

	/** 問題情報テーブルDAO */
	private final QuestionInfoRepository repository;

	/** Dozer Mapper */
	private final Mapper mapper;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<QuestionListInfo> selectQuestionList(){
		return toQuestionListInfos(repository.findAll());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<QuestionListInfo> selectQuestionListByParam(QuestionSearchInfo dto){
		return toQuestionListInfos(findQuestionInfoByParam(dto));
	}
	
	
	/**
	 * ユーザー情報の条件検索を行い、検索結果を返却します。
	 * 
	 * @param form 入力情報
	 * @return 検索結果
	 */
	private List<QuestionInfo> findQuestionInfoByParam(QuestionSearchInfo dto){
		var questionTitleParam = AppUtil.addWildcard(dto.getQuestionTitle());
		return repository.findByQuestionTitleLike(questionTitleParam);
	}
	
	/**
	 * 問題情報EntityのListを問題一覧情報DTOのListに変換します。
	 * 
	 * @param questionInfos 問題情報EntityのList
	 * @return 問題一覧情報DTOのList
	 */
	private List<QuestionListInfo> toQuestionListInfos(List<QuestionInfo> questionInfos) {
		var questionListInfos = new ArrayList<QuestionListInfo>();
		for(QuestionInfo questionInfo : questionInfos) {
			var questionListInfo = mapper.map(questionInfo, QuestionListInfo.class);
			questionListInfo.setQuestionTitle(questionInfo.getQuestionTitle());
			questionListInfos.add(questionListInfo);
		}
		return questionListInfos;
	}
}
