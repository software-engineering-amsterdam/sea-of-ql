package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.type.checker.visitor.QLCheckVisitor;

public class ANTLRParser implements IParse {

	@Override
	public Expr parse(String src) throws ParseError {
		
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		Expr parsedResult = null;
		try {
			parsedResult = parser.start();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
		
		QLCheckVisitor bcv = new QLCheckVisitor();
		Statement statement = (Statement)parsedResult;
		statement.accept(bcv);
		return parsedResult;
	}
}
