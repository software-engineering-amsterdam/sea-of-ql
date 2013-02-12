package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser {//implements IParse {

	//@Override
	public void parse(String src) throws ParseError {
//		ANTLRStringStream stream = new ANTLRStringStream(src);
//		CommonTokenStream tokens = new CommonTokenStream();
//		tokens.setTokenSource(new QLLexer(stream));
//		QLParser parser = new QLParser(tokens);
//		try {
//			return parser.parse();
//		} 
//		catch (RecognitionException e) {
//			throw new ParseError(e.getMessage());
//		}
	}

}
