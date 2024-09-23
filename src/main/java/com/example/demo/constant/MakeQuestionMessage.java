package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MakeQuestionMessage {

	SUCCEED(MessageConst.MAKE_QUESTION_RESIST_SUCCEED, false),

	EXISTED_QUESTION_ID(MessageConst.MAKE_QUESTION_EXISTED_QUESTION_ID, true);

	private String messageId;

	private boolean isError;
}
