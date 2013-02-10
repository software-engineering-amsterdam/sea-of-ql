package org.uva.sea.ql.interpreter.controller;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.Validate;


@UrlBinding(value = DisplayQLActionBean.URL_BINDING)
public class DisplayQLActionBean implements ActionBean {

	/** Constant denoting the url binding for the current action bean. */
    public static final String URL_BINDING = "/protected/questionnaire";
    
    /** Constant denoting the path to the form view. */
	private static final String FORM_VIEW_PATH = "/WEB-INF/jsp/index.jsp";
	
//	@ValidateNestedProperties({
//	    @Validate(field="answer.value", required=true), })
	private List<Question> simpleQuestions;
	
	private ActionBeanContext context;
	
	@DefaultHandler
    public Resolution view() {
		
		CharStream stream = new ANTLRStringStream(
				"form Box1HouseOwning {\n"
						+ "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
						+ "hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
						+ "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
						+ "if (hasSoldHouse) {\n"
						+ "sellingPrice: \"Price the house was sold for:\" money\n"
						+ "privateDebt: \"Private debts for the sold house:\" money\n"
						+ "valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)\n"
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
		simpleQuestions = QLFormUtil.getSimpleOuterQuestions(form);
        return new ForwardResolution(FORM_VIEW_PATH);
    }
	 
	public List<Question> getSimpleQuestions() {
		return simpleQuestions;
	}

	public void setSimpleQuestions(List<Question> simpleQuestions) {
		this.simpleQuestions = simpleQuestions;
	}

	@Override
	public ActionBeanContext getContext() {
		
		return context;
	}

	@Override
	public void setContext(ActionBeanContext arg0) {
		
		context = arg0;
	}

}
