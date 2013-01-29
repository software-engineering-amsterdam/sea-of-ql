package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.parser.test.*;


public class ANTLRParser implements IParse {

	@Override
	public ASTNode parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			Form f = parser.form();
			if(parser.isErrorFound()){
				throw new ParseError(parser.getErrors().toString());
			}
			return f;
			
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		} 
	}
}
