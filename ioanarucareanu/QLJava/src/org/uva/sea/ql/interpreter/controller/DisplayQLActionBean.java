package org.uva.sea.ql.interpreter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.semanticchecker.SemanticVisitor;
import org.uva.sea.ql.semanticchecker.ValidationReport;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding(value = DisplayQLActionBean.URL_BINDING)
public class DisplayQLActionBean implements ActionBean {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/questionnaire";
    
    /** Constant denoting the path to the form view. */
	private static final String FORM_VIEW_PATH = "/WEB-INF/jsp/index.jsp";
	
	private List<AnswerableQuestion> questions;
	
	private ActionBeanContext context;
	
	@DefaultHandler
    public Resolution view() {
		
		CharStream stream = new ANTLRStringStream(
				"form Box1HouseOwning {\n"
						+ "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
						+ "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean\n"
						+ "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
						+ "if (hasSoldHouse) {\n"
						+ "sellingPrice: \"Price the house was sold for:\" int\n"
						+ "privateDebt: \"Private debts for the sold house:\" int\n"
						+ "valueResidue: \"Value residue:\" int(sellingPrice - privateDebt)\n"
						+ "}\n" + "}");
		QLLexer lexer = new QLLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		QLForm form = null;
		try {
			form = parser.qlform();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SemanticVisitor visitor = new SemanticVisitor();		
		questions = new ArrayList<AnswerableQuestion>();
		ValidationReport validationReport = visitor.start(form); 
		if (validationReport.getErrors().isEmpty()) {
			List<Question> simpleQuestions = QLFormUtil.getSimpleOuterQuestions(form.getBlockOfItems());
			HttpSession session = context.getRequest().getSession(); 
			session.setAttribute("statementsLeft",QLFormUtil.getDependentStatements(form));
			Map<Ident, Pair<Type, Val>> symbolTypeValueTable = new HashMap<Ident, Pair<Type, Val>>();
			Map<Ident, Type> symbolTypeTable = visitor.getSymbolTable();
			for (Map.Entry<Ident, Type> entry : symbolTypeTable.entrySet()) {
				symbolTypeValueTable.put(entry.getKey(), new Pair<Type, Val>(entry.getValue(), null));
			}
			session.setAttribute("symbolTypeValueTable", symbolTypeValueTable);
			for (Question question : simpleQuestions) {
				questions.add(new AnswerableQuestion(question));
			}
		} 
        return new ForwardResolution(FORM_VIEW_PATH);
    }
	
	public Resolution next() {
		return new ForwardResolution(URL_BINDING);
	}

	public List<AnswerableQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<AnswerableQuestion> questions) {
		this.questions = questions;
	}
	
	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}
	
	@Override
	public void setContext(ActionBeanContext context) {
		
		this.context = context;
	}

}