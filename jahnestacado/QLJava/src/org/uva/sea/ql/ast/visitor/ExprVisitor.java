package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.values.BoolLit;
import org.uva.sea.ql.ast.values.Decimal;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.StringLit;

public interface Visitor {
	/*
		public boolean public boolean visit(Binary expr);
		public boolean public boolean visit(Form form);
		public boolean public boolean visit(Body body);
		public boolean public boolean visit(Question question);
		public boolean public boolean visit(ComputedQuestion computedQuestion);
		*/
	
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
