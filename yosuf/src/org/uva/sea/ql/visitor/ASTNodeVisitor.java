package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.exp.Expression;

public interface ASTNodeVisitor {

	void visit(Form form);

	void visi(Expression expression);

	void visit(CompoundStatement compoundStatement);

}
