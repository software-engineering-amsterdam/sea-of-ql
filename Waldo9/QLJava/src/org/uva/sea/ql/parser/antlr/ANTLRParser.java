package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class ANTLRParser implements IParse {

	@Override
	public Expr parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);		
		QLLexer qlLexer = new QLLexer(stream);
		Token token;
	    while (true) {
	        token = qlLexer.nextToken();
	        if (token.getType() == Token.EOF) {
	            break;
	        }
	        System.out.println(token.getText());
	    }
	    qlLexer.reset();
	    CommonTokenStream tokens = new CommonTokenStream(qlLexer);
		QLParser parser = new QLParser(tokens);
		try {
			return parser.orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

}
