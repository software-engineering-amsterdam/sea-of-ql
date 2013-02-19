package org.uva.sea.ql.interpreter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.interpreter.EnabledQuestions;
import org.uva.sea.ql.interpreter.InterpreterVisitor;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;

public abstract class ProcessResponseActionBean implements ActionBean {
    
	private static final String ACTION_BEAN_PATH_PARAM = "actionBeanPath";

	/** Constant denoting the path to the form view. */
	private static final String FORM_VIEW_PATH = "/WEB-INF/jsp/extraQuestionsFragment.jsp";
	
	@Validate(required=true)
	private String identName;
	
	private QLForm questionsForm;
	
	private Map<Ident, TypeValuePair> symbolTypeValueTable;
	
//	private List<QuestionWithAnswer> questions;
	
	private ActionBeanContext context;
	
	private void initAttrFromSession() {
		HttpSession session = context.getRequest().getSession(); 
		questionsForm = (QLForm) session.getAttribute(DisplayQLActionBean.QUESTIONS_FORM_SESSION_ATTR);
		symbolTypeValueTable = (Map<Ident, TypeValuePair>) session.getAttribute(DisplayQLActionBean.SYMBOL_TABLE_SESSION_ATTR);
	}
	
	private void saveAttrOnSession() {
		HttpSession session = context.getRequest().getSession();
		session.setAttribute(DisplayQLActionBean.SYMBOL_TABLE_SESSION_ATTR, symbolTypeValueTable);
	}
	
	@DefaultHandler
	public Resolution view() {
		
		initAttrFromSession();
		Ident ident = new Ident(getIdentName());
		Val val = getAnswerVal();
		symbolTypeValueTable.get(ident).setValue(val);
//		questions = new ArrayList<QuestionWithAnswer>();
//		findEnabledQuestionsToBeAnswered();
		saveAttrOnSession();
		resetAnswer();
		return new RedirectResolution(DisplayQLActionBean.URL_BINDING + "?view=");
//		return new ForwardResolution(FORM_VIEW_PATH).
//				addParameter(ACTION_BEAN_PATH_PARAM, getActionBeanClassName());
	}
	
	protected abstract void resetAnswer();
	
	protected abstract String getActionBeanClassName();
	
//	private void findEnabledQuestionsToBeAnswered() {
//		InterpreterVisitor visitor = new InterpreterVisitor(symbolTypeValueTable);
//		questions = ((EnabledQuestions) questionsForm.accept(visitor)).getQuestions();
//	}
	
	public String getIdentName() {
		return identName;
	}

	public void setIdentName(String identName) {
		this.identName = identName;
	}
	
	public abstract Val getAnswerVal();

//	public List<QuestionWithAnswer> getQuestions() {
//		return questions;
//	}

	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		
		this.context = context;
	}

}
