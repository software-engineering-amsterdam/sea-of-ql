package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.VarDeclaration;

/**
 * Statement visitor.
 */
public interface IStatementVisitor {
	/**
	 * Visit IF-statement.
	 * 
	 * @param node
	 */
	void visit( If node );
	
	/**
	 * Visit a variable declaration.
	 * 
	 * @param node
	 */
	void visit( VarDeclaration node );
	
	/**
	 * Visit an assignment.
	 * 
	 * @param node
	 */
	void visit( Assignment node );
}
