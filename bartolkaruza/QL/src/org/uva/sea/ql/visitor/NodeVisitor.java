package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
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
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;

public interface NodeVisitor {

	public void visit(Form node);

	public void visit(ConditionalStatement node);

	public void visit(Ident node);

	public void visit(Question node);

	public void visit(Add node);

	public void visit(And node);

	public void visit(Div node);

	public void visit(Eq node);

	public void visit(GEq node);

	public void visit(GT node);

	public void visit(LEq node);

	public void visit(LT node);

	public void visit(Mul node);

	public void visit(Neg node);

	public void visit(NEq node);

	public void visit(Not node);

	public void visit(Or node);

	public void visit(Pos node);

	public void visit(Sub node);

	public void visit(Bool node);

	public void visit(Int node);

	public void visit(Money node);

	public void visit(TextString node);

}
