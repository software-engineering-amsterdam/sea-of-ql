package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.type.TypeCheckError;
import org.uva.sea.ql.type.checker.QLTypeChecker;


public class ANTLRParser implements IParse {

	@Override
	public Expr parse(String src) throws ParseError {
		
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		QLTypeChecker checker = new QLTypeChecker();
		Expr parsedResult = null;
		try {
			parsedResult = parser.start();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
		
		try{
			parsedResult = checker.check(parsedResult);
		} catch(TypeCheckError tce){
			System.out.println("TypeCheckError Found: ");
			System.out.println(tce.getMessage());
		}
		return parsedResult;
	}

}
