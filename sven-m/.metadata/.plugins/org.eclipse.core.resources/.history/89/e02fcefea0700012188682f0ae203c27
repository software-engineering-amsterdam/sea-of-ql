package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class QLFormParser implements IParse {
	
	private QLParser prepareParse(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		
		return new QLParser(tokens);
	}
	
	@Override
	public Form parse(String src) throws ParseError {
		return parseForm(src);
	}

	public Form parseForm(String src) throws ParseError {
		QLParser parser = prepareParse(src);
		
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	public Body parseBody(String src) throws ParseError {
		QLParser parser = prepareParse(src);
		
		try {
			return parser.topLevelBody();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	public FormElement parseFormElement(String src) throws ParseError {
		QLParser parser = prepareParse(src);
		
		try {
			return parser.topLevelFormElement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	public Expr parseExpression(String src) throws ParseError {
		QLParser parser = prepareParse(src);
		
		try {
			return parser.topLevelExpression();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}
