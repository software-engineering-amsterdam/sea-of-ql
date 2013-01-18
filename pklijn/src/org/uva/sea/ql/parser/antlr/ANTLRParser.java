package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.form.Form;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

	@Override
	public Expr parse(String src) throws ParseError {
		QLParser parser = createParser(src);
		try {
			return parser.orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	@Override
	public Form parseForm(String src) throws ParseError {
		QLParser parser = createParser(src);
		try {
			return parser.form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	private QLParser createParser(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		return new QLParser(tokens);
	}

}
