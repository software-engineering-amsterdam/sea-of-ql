package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IFormElement;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import java.util.List;

public class ANTLRParser implements IParse {
	
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
		}
	}
	
	@Override
	public IFormElement parseFormElement(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.formElement();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}


	@Override
	public Form parseForm(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	@Override
	public List<IFormElement> parseFormElements(String src) throws ParseError {
		QLParser parser = new QLParser(getTokens(src));
		try {
			return parser.formElementList();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	

	
}
