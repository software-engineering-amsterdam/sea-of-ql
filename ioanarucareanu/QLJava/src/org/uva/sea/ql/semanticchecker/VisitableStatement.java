package org.uva.sea.ql.semanticchecker;

public interface VisitableStatement {
	
	void accept(StatementSemanticVisitor visitor);

}
