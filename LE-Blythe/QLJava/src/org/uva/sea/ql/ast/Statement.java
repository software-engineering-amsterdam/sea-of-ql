package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.IVisitableStatement;
import org.uva.sea.ql.ast.statement.IVisitorStatement;


public abstract class Statement implements ASTNode, IVisitableStatement {

	public abstract <T> T accept(IVisitorStatement<T> visitor); 
}
