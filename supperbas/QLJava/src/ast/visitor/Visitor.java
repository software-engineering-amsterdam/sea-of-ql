package ast.visitor;

import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;

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
}
