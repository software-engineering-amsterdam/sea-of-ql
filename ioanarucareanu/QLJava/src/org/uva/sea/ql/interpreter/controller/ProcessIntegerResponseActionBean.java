package org.uva.sea.ql.interpreter.controller;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.Val;

@UrlBinding(ProcessIntegerResponseActionBean.URL_BINDING)
public class ProcessIntegerResponseActionBean extends ProcessResponseActionBean implements ValidationErrorHandler {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/question/process/int";
	
	@Validate(required=true)
	private Integer answer;
	
	public Integer getAnswer() {
		return answer;
	}
	
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	@Override
	protected void resetAnswer() {
		answer = null;
	}

	@Override
	public Val getAnswerVal() {
		return new IntegerVal(answer);
	}

	@Override
	protected String getActionBeanClassName() {
		return getClass().getName();
	}

	@Override
	public Resolution handleValidationErrors(ValidationErrors arg0)
			throws Exception {
		ValidationErrors errors = getContext().getValidationErrors();
		return null;
	}

}
