package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.algebraic.Add;
import org.uva.sea.ql.ast.expr.binary.algebraic.Div;
import org.uva.sea.ql.ast.expr.binary.algebraic.Mul;
import org.uva.sea.ql.ast.expr.binary.algebraic.Sub;
import org.uva.sea.ql.ast.expr.binary.bool.And;
import org.uva.sea.ql.ast.expr.binary.bool.Eq;
import org.uva.sea.ql.ast.expr.binary.bool.GEq;
import org.uva.sea.ql.ast.expr.binary.bool.GT;
import org.uva.sea.ql.ast.expr.binary.bool.LEq;
import org.uva.sea.ql.ast.expr.binary.bool.LT;
import org.uva.sea.ql.ast.expr.binary.bool.NEq;
import org.uva.sea.ql.ast.expr.binary.bool.Or;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
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
