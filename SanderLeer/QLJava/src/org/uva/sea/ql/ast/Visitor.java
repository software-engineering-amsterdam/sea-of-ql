package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

public interface Visitor {
	void visit(Pos node);
	void visit(Neg node);
	void visit(Not node);
	void visit(Mul node);
	void visit(Div node);
	void visit(Add node);
	void visit(Sub node);
	void visit(Eq node);
	void visit(NEq node);
	void visit(GT node);
	void visit(LT node);
	void visit(GEq node);
	void visit(LEq node);
	void visit(And node);
	void visit(Or node);
	void visit(Identifier node);
	void visit(IntegerLiteral node);
	void visit(BooleanLiteral node);
	void visit(StringLiteral node);
	void visit(Form node);
	void visit(Question node);
	void visit(ComputedQuestion node);
	void visit(StringType node);
	void visit(StatementList node);
	void visit(BooleanType node);
	void visit(IntegerType node);
	void visit(IfStatement node);
}
