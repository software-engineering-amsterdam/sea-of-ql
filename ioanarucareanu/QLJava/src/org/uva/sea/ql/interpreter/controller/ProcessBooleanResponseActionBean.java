package org.uva.sea.ql.interpreter.controller;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.ExpressionInterpreterVisitor;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding(value = ProcessBooleanResponseActionBean.URL_BINDING)
public class ProcessBooleanResponseActionBean implements ActionBean {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/question/process/bool";
    
    /** Constant denoting the path to the form view. */
	private static final String FORM_VIEW_PATH = "/WEB-INF/jsp/extraQuestionsFragment.jsp";
	
	@Validate(field="answer", required=true)
	private Boolean answer;
	@Validate(field="identName", required=true)
	private String identName;
	
	private List<AnswerableQuestion> questions;
	
	private List<Statement> statementsLeft;
	
	private Map<Ident, Pair<Type, Val>> symbolTypeValueTable;
	
	private ActionBeanContext context;
	
	private void readAttributesFromSession() {
		HttpSession session = context.getRequest().getSession(); 
		statementsLeft = (List<Statement>) session.getAttribute("statementsLeft");
		symbolTypeValueTable = (Map<Ident, Pair<Type, Val>>) session.getAttribute("symbolTypeValueTable");
	}
	
	@DefaultHandler
	public Resolution view() {
		
		readAttributesFromSession();
		
		Ident ident = new Ident(identName);
		BooleanVal val = new BooleanVal(answer);
		symbolTypeValueTable.get(ident).setRight(val);
		questions = new ArrayList<AnswerableQuestion>();
		List<Question> enabledQuestions = searchEnabledConditions(statementsLeft, symbolTypeValueTable);
		for (Question question : enabledQuestions) {
			questions.add(new AnswerableQuestion(question));
		}
		answer = null;
		return new ForwardResolution(FORM_VIEW_PATH).
				addParameter("actionBeanPath", getClass().getName());
	}
	
	private List<Question> searchEnabledConditions(List<Statement> statements, Map<Ident, Pair<Type, Val>> symbolTypeValueTable) {
		List<Question> enabledIndependentQuestions = new ArrayList<Question>();
		ExpressionInterpreterVisitor visitor = new ExpressionInterpreterVisitor(symbolTypeValueTable);
		for (Statement statement : statements) {
			// TODO not ok; belong to visitor
			if (statement instanceof ConditionalQuestion) {
				ConditionalQuestion condQ = (ConditionalQuestion) statement;
				Expr condition = condQ.getCondition();
				BooleanVal success = (BooleanVal) condition.accept(visitor);
				//check if is set
				if (success.getValue()) {
					enabledIndependentQuestions.addAll(QLFormUtil.getSimpleOuterQuestions(condQ.getStatements()));	
				}
			}
			if (statement instanceof ComputedQuestion) {
				ComputedQuestion compQ = (ComputedQuestion) statement;
				Expr computed = compQ.getExpr();
				Val returnedValue = (Val) computed.accept(visitor);
				if (returnedValue.isDefined()) {
//					this.symbolTypeValueTable.get(key)
					enabledIndependentQuestions.add(compQ);
				}
			}
		}
		return enabledIndependentQuestions;
	}
	
	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

	public String getIdentName() {
		return identName;
	}

	public void setIdentName(String identName) {
		this.identName = identName;
	}

	public List<AnswerableQuestion> getQuestions() {
		return questions;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		
		this.context = context;
	}

}
