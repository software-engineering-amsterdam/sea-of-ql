package org.uva.sea.ql.interpreter.controller;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.UndefinedVal;
import org.uva.sea.ql.ast.expr.value.Val;

@UrlBinding(ProcessIntegerResponseActionBean.URL_BINDING)
public class ProcessIntegerResponseActionBean extends ProcessResponseActionBean  {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/question/process/int";

	private Integer answer;
	
	public Integer getAnswer() {
		return answer;
	}
	
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	@Override
	public Val getAnswerVal() {
		if (answer == null) {
			return new UndefinedVal();
		}
		return new IntegerVal(answer);
	}

}
