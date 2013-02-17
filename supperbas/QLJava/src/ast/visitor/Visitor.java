package ast.visitor;

import ast.Form;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;
import ast.statement.*;

public interface Visitor<T> {
	T visit(Add ast);
	T visit(And ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(Neg ast);
	T visit(NEq ast);
	T visit(Not ast);
	T visit(Or ast);
	T visit(Pos ast);
	T visit(Sub ast);
	T visit(Bool ast);	
	T visit(Str ast);
	T visit(Money ast);
	T visit(Int ast);
	T visit(Ident ast);
	T visit(Assignment ast);
	T visit(Else ast);
	T visit(Form ast);
	T visit(If ast);
	T visit(Question ast);
	T visit(Var ast);
	T visit(ast.type.Bool ast);
	T visit(ast.type.Str ast);
	T visit(ast.type.Ident ast);
	T visit(ast.type.Int ast);
	T visit(ast.type.Message ast);
	T visit(ast.type.Money ast);
	T visit(ast.type.Numeric ast);
	T visit(Block ast);
}
