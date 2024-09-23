package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.QuestionInfo;
import com.example.demo.form.MakeQuestionForm;
import com.example.demo.repository.QuestionInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面Service実装クラス
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class MakeQuestionServiceImpl implements MakeQuestionService{

	private final QuestionInfoRepository repository;
	
	/** Dozer Mapper */
	private final Mapper mapper;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<QuestionInfo> resistQuestionInfo(MakeQuestionForm form) {

		var questionInfo = mapper.map(form, QuestionInfo.class);
		
		questionInfo.getQuestionTitle();
		questionInfo.getQuestionScript();
		questionInfo.getAnswerFirst();
		questionInfo.getAnswerSecond();
		questionInfo.getAnswerThird();
		questionInfo.getAnswerFourth();
		questionInfo.getQuestionAnswer();

		return Optional.of(repository.save(questionInfo));
	}
}
