package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Condition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

/**
 * Interface: Visitor
 * @author Danny
 *
 */
public interface Visitor {

	// Elements, nodes
	public void visit(Form f);
	public void visit(FormElement fe);
	public void visit(Question q);
	public void visit(Computation c);
	public void visit(Condition c);	
	public void visit(Ident i);
	public void visit(BinExpr b);
	public void visit(UnaryExpr u);
	public void visit(Expr e);
	public void visit(Type t);

}
