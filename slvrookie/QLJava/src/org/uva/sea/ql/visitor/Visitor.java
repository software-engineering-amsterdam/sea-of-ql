package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
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
}
