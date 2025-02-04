package com.example.demo.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.MakeQuestionMessage;
import com.example.demo.constant.MessageConst;
import com.example.demo.constant.UrlConst;
import com.example.demo.constant.ViewNameConst;
import com.example.demo.entity.QuestionInfo;
import com.example.demo.form.MakeQuestionForm;
import com.example.demo.service.MakeQuestionService;
import com.example.demo.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面 Controller
 * 
 * @author ys-fj
 *
 */
@Controller
@RequiredArgsConstructor
public class MakeQuestionController {

	/** ユーザー登録画面 Service */
	private final MakeQuestionService service;

	/** メッセージソース */
	private final MessageSource messageSource;

	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @return　表示画面
	 */
	@GetMapping(UrlConst.MAKE_QUESTION)
	public String view(Model model, MakeQuestionForm form) {
		return ViewNameConst.MAKE_QUESTION;
	}

	/**
	 * 問題登録
	 * 
	 * @param model モデル
	 * @param form 入力情報
	 * @param bdResult 入力チェック結果
	 * @return 表示画面
	 */
	@PostMapping("/makeQuestion")
	public void signup(Model model, @Validated MakeQuestionForm form, BindingResult bdResult) {
		if (bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
			return;
		}

		var questionInfoOpt = service.resistQuestionInfo(form);
		var makeQuestionMessage = judgeMessageKey(questionInfoOpt);
		editGuideMessage(model, makeQuestionMessage.getMessageId(), makeQuestionMessage.isError());
	}

	/**
	 * 画面に表示するガイドメッセージを設定する
	 * 
	 * @param model モデル
	 * @param messageId メッセージID
	 * @param isError エラー有無
	 */
	private void editGuideMessage(Model model, String messageId, boolean isError) {
		var message = AppUtil.getMessage(messageSource, messageId);
		model.addAttribute("message", message);
		model.addAttribute("isError", isError);
	}

	/**
	 * ユーザ情報登録の結果メッセージキーを判断する
	 * 
	 * @param questionInfoOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	private MakeQuestionMessage judgeMessageKey(Optional<QuestionInfo> questionInfoOpt) {
		if (questionInfoOpt.isEmpty()) {
			return MakeQuestionMessage.EXISTED_QUESTION_ID;
		} else {
			return MakeQuestionMessage.SUCCEED;
		}
	}
}
