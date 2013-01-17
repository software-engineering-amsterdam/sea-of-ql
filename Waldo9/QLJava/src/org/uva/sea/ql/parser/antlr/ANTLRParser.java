package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

	@Override
	public Form parseForm(String src) throws ParseError {
		return (Form)parse(src, ParseType.Form);
	}
	
	@Override
	public Expr parseExpr(String src) throws ParseError {
		return (Expr)parse(src, ParseType.Expr);
	}
	
	private ASTNode parse(String src, ParseType parseType) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);		
		QLLexer qlLexer = new QLLexer(stream);
	    CommonTokenStream tokens = new CommonTokenStream(qlLexer);
		QLParser parser = new QLParser(tokens);
		try {
			if (parseType == ParseType.Expr)
				return parser.orExpr();
			else if (parseType == ParseType.Form)
				return parser.form();
			else
				return null;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
