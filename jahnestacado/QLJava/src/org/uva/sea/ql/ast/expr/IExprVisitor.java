package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Decimal;
import org.uva.sea.ql.ast.expr.values.Int;
import org.uva.sea.ql.ast.expr.values.StringLit;

public interface IExprVisitor {
	
	
	 public boolean visit(Add node);
	 public boolean visit(And node);
	 public boolean visit(Div node);
	 public boolean visit(Eq node);
	 public boolean visit(GEq node);
	 public boolean visit(GT node);
	 public boolean visit(Ident node);
	 public boolean visit(LEq node);
	 public boolean visit(LT node);
	 public boolean visit(Mul node);
	 public boolean visit(Neg node);
	 public boolean visit(NEq node);
	 public boolean visit(Not node);
	 public boolean visit(Or node);
	 public boolean visit(Pos node);
	 public boolean visit(Sub node);
	 public boolean visit(Int node);
	 public boolean visit(BoolLit node);
	 public boolean visit(Decimal node);
	 public boolean visit(StringLit node);
}
