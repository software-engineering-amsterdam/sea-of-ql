package khosrow.uva.sea.ql.parser.jacc;

import java.io.StringReader;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.stmt.Stmt;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;

public class JACCParser implements IParse {
	
	private QLParser parse(String src) throws ParseError {
		QLLexer lexer = new QLLexer(new StringReader(src));
		lexer.nextToken();
		QLParser parser = new QLParser(lexer);
		if (!parser.parse()) {
			throw new ParseError("error");
		}
		return parser;
	}

	@Override
	public Form ParseForm(String src) throws ParseError {
		return this.parse(src).getFormResult();
	}
	@Override
	public Stmt ParseStatement(String src) throws ParseError {
		return this.parse(src).getStatementResult();
	}

	@Override
	public Expr ParseExpression(String src) throws ParseError {
		return this.parse(src).getExpressionResult();
	}

}
