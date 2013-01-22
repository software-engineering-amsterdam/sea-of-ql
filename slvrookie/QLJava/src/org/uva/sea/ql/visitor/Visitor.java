package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.expr.value.*;

public interface Visitor {
	
	void visit(Form node, Context context);
	void visit(Question node, Context context);
	void visit(IfBody node, Context context);
	void visit(UnaryExpr node, Context context);
	void visit(BinaryExpr node, Context context);
	void visit(CompQuestion node, Context context);
	void visit(BoolLiteral node, Context context);
	void visit(IntLiteral node, Context context);
	void visit(MoneyLiteral node, Context context);
	void visit(StringLiteral node, Context context);
	void visit(Ident node, Context context);
	void visit(Add node, Context context);
	void visit(And node, Context context);
	void visit(Div node, Context context);
	void visit(Eq node, Context context);
	void visit(GEq node, Context context);
	void visit(GT node, Context context);
	void visit(LEq node, Context context);
	void visit(LT node, Context context);
	void visit(Mul node, Context context);
	void visit(NEq node, Context context);
	void visit(Or node, Context context);
	void visit(Sub node, Context context);
	void visit(Neg node, Context context);
	void visit(Not node, Context context);
	void visit(Pos node, Context context);
	
}
