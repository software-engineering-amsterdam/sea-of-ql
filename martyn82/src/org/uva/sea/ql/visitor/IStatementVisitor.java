package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
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
	void visit( IfThenElse node );

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

	/**
	 * Visit form declaration node.
	 *
	 * @param node
	 */
	void visit( FormDeclaration node );

	/**
	 * Visit question declaration node.
	 *
	 * @param node
	 */
	void visit( QuestionDeclaration node );
}
