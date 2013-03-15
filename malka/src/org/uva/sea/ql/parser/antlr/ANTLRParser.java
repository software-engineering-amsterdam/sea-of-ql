package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

import java.util.List;
import java.util.Stack;

public class ANTLRParser implements IParse {
	private List<String> errors = new Stack<String>();
	
	@Override
	public List<String> getErrors() {
		return errors;
	}
	
	private CommonTokenStream getTokens(String src)
	{
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return tokens;
	}
	
	@Override
	public Expression parseExpr(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} finally {
			errors = parser.getErrors();
		}
	}
	
	@Override
	public FormElement parseFormElement(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.formElement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} finally {
			errors = parser.getErrors();
		}
	}


	@Override
	public Form parseForm(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} finally {
			errors = parser.getErrors();
		}
	}
	
	@Override
	public List<FormElement> parseFormElements(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.formElementList();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} finally {
			errors = parser.getErrors();
		}
	}	
}
