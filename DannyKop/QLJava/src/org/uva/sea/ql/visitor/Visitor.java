package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.Add;
import org.uva.sea.ql.ast.expressions.binary.And;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.binary.Div;
import org.uva.sea.ql.ast.expressions.binary.Eq;
import org.uva.sea.ql.ast.expressions.binary.GEq;
import org.uva.sea.ql.ast.expressions.binary.GT;
import org.uva.sea.ql.ast.expressions.binary.LEq;
import org.uva.sea.ql.ast.expressions.binary.LT;
import org.uva.sea.ql.ast.expressions.binary.Mul;
import org.uva.sea.ql.ast.expressions.binary.NEq;
import org.uva.sea.ql.ast.expressions.binary.Or;
import org.uva.sea.ql.ast.expressions.binary.Sub;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

/**
 * Interface: Visitor
 * @author Danny
 *
 */
public interface Visitor <T> {
	// Elements, nodes
	public T visit(Form f);
	public T visit(FormElement fe);
	public T visit(Question q);
	public T visit(Computation c);
	public T visit(IfThen i);
	public T visit(IfThenElse i);
	public T visit(Ident i);
	public T visit(BinExpr b);
	public T visit(UnaryExpr u);
	public T visit(Expr e);
	public T visit(Type t);
	
	// 'operations'
	public T visit(Add a);
	public T visit(And a);
	public T visit(Div d);
	public T visit(Mul m);
	public T visit(Or o);
	public T visit(Sub s);
	public T visit(Eq e);
	public T visit(GEq g);
	public T visit(GT g);
	public T visit(LEq l);
	public T visit(LT l);
	public T visit(NEq n);
	public T visit(Neg n);
	public T visit(Not n);
	public T visit(Pos p);
}
