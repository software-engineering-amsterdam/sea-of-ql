package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

public interface Visitor<T> {
	T visit(Pos node);
	T visit(Neg node);
	T visit(Not node);
	T visit(Mul node);
	T visit(Div node);
	T visit(Add node);
	T visit(Sub node);
	T visit(Eq node);
	T visit(NEq node);
	T visit(GT node);
	T visit(LT node);
	T visit(GEq node);
	T visit(LEq node);
	T visit(And node);
	T visit(Or node);
	T visit(Identifier node);
	T visit(IntegerLiteral node);
	T visit(BooleanLiteral node);
	T visit(StringLiteral node);
	T visit(Form node);
	T visit(Question node);
	T visit(ComputedQuestion node);
	T visit(StringType node);
	T visit(StatementList node);
	T visit(BooleanType node);
	T visit(IntegerType node);
	T visit(IfStatement node);
}
