package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Context;

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
	T visit( IfThenElse node, Context context );

	/**
	 * Visit a variable declaration.
	 *
	 * @param node
	 * @param context
	 */
	T visit( VarDeclaration node, Context context );

	/**
	 * Visit an assignment.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Assignment node, Context context );

	/**
	 * Visit form declaration node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	T visit( FormDeclaration node, Context context );

	/**
	 * Visit question declaration node.
	 *
	 * @param node
	 * @param context
	 */
	T visit( QuestionDeclaration node, Context context );

	/**
	 * Visit statements node.
	 *
	 * @param node
	 * @param context
	 */
	T visit( Statements node, Context context );
}
