package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Environment;

/**
 * Statement visitor.
 */
public interface IStatementVisitor<T> {
	/**
	 * Visit IF-statement.
	 *
	 * @param node
	 * @param context
	 */
	T visit( IfThenElse node, Environment context );

	/**
	 * Visit a variable declaration.
	 *
	 * @param node
	 * @param context
	 */
	T visit( VarDeclaration node, Environment context );

	/**
	 * Visit an assignment.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Assignment node, Environment context );

	/**
	 * Visit form declaration node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	T visit( FormDeclaration node, Environment context );

	/**
	 * Visit question declaration node.
	 *
	 * @param node
	 * @param context
	 */
	T visit( QuestionDeclaration node, Environment context );

	/**
	 * Visit statements node.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Statements node, Environment context );
}
