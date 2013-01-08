package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Stmt;
import org.uva.sea.ql.ast.expr.Expr;

public interface NodeVisitor {

	public void visit(Form node);

	public void visit(Ident node);

	public void visit(Int node);

	public void visit(Expr expr);

	public void visit(Question node);

	public void visit(Stmt node);

}
