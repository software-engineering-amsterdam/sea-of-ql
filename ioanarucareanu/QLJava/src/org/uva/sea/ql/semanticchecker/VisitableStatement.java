package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.StatementVisitor;

public interface VisitableStatement {
	
	void accept(StatementVisitor visitor);

}
