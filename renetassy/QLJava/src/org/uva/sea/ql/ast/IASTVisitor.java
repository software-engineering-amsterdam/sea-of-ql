package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.expr.Sub;

public interface IASTVisitor {
	
	boolean visit(Add node);
	boolean visit(And node);
	boolean visit(Div node);
	boolean visit(Eq node);
	boolean visit(GEq node);
	boolean visit(GT node);
	boolean visit(Ident node);
	boolean visit(Int node);
	boolean visit(LEq node);
	boolean visit(LT node);
	boolean visit(Mul node);
	boolean visit(Neg node);
	boolean visit(NEq node);
	boolean visit(Not node);
	boolean visit(Or node);
	boolean visit(Pos node);
	boolean visit(Sub node);
	boolean visit(BoolLiteral node);
	boolean visit(StringLiteral node);
	
}
