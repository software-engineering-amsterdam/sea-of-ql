package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;

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

}
