package khosrow.uva.sea.ql.parser.test;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.stmt.Stmt;

public interface IParse {
	Form ParseForm(String src) throws ParseError;
	Stmt ParseStatement(String src) throws ParseError;
	Expr ParseExpression(String src) throws ParseError;
}
