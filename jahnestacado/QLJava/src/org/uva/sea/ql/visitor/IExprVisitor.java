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
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;

public interface IExprVisitor<T> {
	
	
	 public T visit(Add node);
	 public T visit(And node);
	 public T visit(Div node);
	 public T visit(Eq node);
	 public T visit(GEq node);
	 public T visit(GT node);
	 public T visit(Ident node);
	 public T visit(LEq node);
	 public T visit(LT node);
	 public T visit(Mul node);
	 public T visit(Neg node);
	 public T visit(NEq node);
	 public T visit(Not node);
	 public T visit(Or node);
	 public T visit(Pos node);
	 public T visit(Sub node);
	 public T visit(IntegerLit node);
	 public T visit(BoolLit node);
	 public T visit(DecimalLit node);
	 public T visit(StringLit node);
	 
	 
	
}
