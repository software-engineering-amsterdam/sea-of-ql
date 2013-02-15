package org.uva.sea.ql.ast;

import org.uva.sea.ql.semanticchecker.VisitableStatement;

public abstract class Statement implements ASTNode, VisitableStatement {
	
	/**
	 * Indicates whether the statement is dependent on other unknown values 
	 * at compile-time. Example: a conditional statement with a boolean condition 
	 * computed at run-time, when all the variables are known.
	 *  
	 * @return true if the statement is dependent on other values, false otherwise 
	 */
	public abstract boolean isDependent();
}
