package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.StmtVisitor;

public abstract class Statement implements ASTNode {

	public abstract void accept(StmtVisitor visitor);
}