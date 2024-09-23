package com.example.demo.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.SessionKeyConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.dto.QuestionSearchInfo;
import com.example.demo.form.QuestionListForm;
import com.example.demo.service.QuestionListService;
import com.example.demo.util.AppUtil;
import com.github.dozermapper.core.Mapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 問題一覧画面Controllerクラス
 * 
 * @author takke
 * 
 */
@Controller
@RequiredArgsConstructor
public class QuestionListController {
	
	/** 問題一覧画面Serviceクラス */
	private final QuestionListService service;
	
	/** Dozer Mapper */
	private final Mapper mapper;
	
	/** メッセージソース */
	private final MessageSource messageSource;
	
	/** セッションオブジェクト */
	private final HttpSession session;
	
	/** モデルキー：問題情報リスト */
	private static final String KEY_QUESTIONLIST = "questionList";
	
	/** モデルキー：問題情報リスト */
	private static final String KEY_QUESTION_TITLE = "questionTitle";
	
	/** モデルキー：ユーザー情報リスト */
	private static final String KEY_AUTHORITY_KIND_OPTIONS = "authorityKindOptions";
	
	/**
	 * 画面の初期表示を行います。
	 * 
	 * <p>またその際、画面選択項目「アカウント状態」「所有権限」の選択肢を生成して渡します。
	 * 
	 * @param model モデル
	 * @return 表示画面
	 */
	@GetMapping(UrlConst.QUESTION_LIST)
	public String view(Model model, QuestionListForm form) {
		session.removeAttribute(SessionKeyConst.SELECTED_QUESTION_ID);
		
		var questionInfos = service.selectQuestionList();
		model.addAttribute(KEY_QUESTIONLIST, questionInfos);
		
		return ViewNameConst.QUESTION_LIST;
	}
	
	/**
	 * ユーザー情報検索
	 * 
	 * 検索条件に合致する問題情報を画面に表示する
	 * 
	 * @param model モデル
	 * @return 表示画面
	 */
	@PostMapping(value = UrlConst.QUESTION_LIST, params = "search")
	public String searchQuestion(Model model, QuestionListForm form) {
		var searchDto = mapper.map(form, QuestionSearchInfo.class);
		var questionInfos = service.selectQuestionListByParam(searchDto);
		model.addAttribute(KEY_QUESTIONLIST, questionInfos);
		
		return ViewNameConst.QUESTION_LIST;
	}
	
	/**
	 * 選択行の問題情報を選択して、最新情報で画面を再表示します。
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return リダイレクトURL
	 */
	@PostMapping(value = UrlConst.QUESTION_LIST, params = "select")
	public String selectQuestion(QuestionListForm form) {
		session.setAttribute(SessionKeyConst.SELECTED_QUESTION_ID, form.getSelectedQuestionId());
		return AppUtil.doRedirect(UrlConst.PLAY_QUESTION);
	}
	

}
