package org.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;

public class JaccQLParser implements IParse {

	@Override
	public Form parseForm(String src) throws ParseError {
		return this.parse(src).getFormResult();
	}

	@Override
	public Expression parseExpression(String src) throws ParseError {
		return this.parse(src).getExpressionResult();
	}

	@Override
	public Statement parseStatement(String src) throws ParseError {
		return this.parse(src).getStatementResult();
	}
	
	private QLParser parse(final String qlText) throws ParseError {
		final QLLexer lexer = new QLLexer(new StringReader(qlText));
		lexer.nextToken();
		final QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser;
	}

}