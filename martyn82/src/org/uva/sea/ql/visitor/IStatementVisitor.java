package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;

/**
 * Statement visitor.
 */
public interface IStatementVisitor {
	/**
	 * Visit IF-statement.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( IfThenElse node, Context context );

	/**
	 * Visit a variable declaration.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( VarDeclaration node, Context context );

	/**
	 * Visit an assignment.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( Assignment node, Context context );

	/**
	 * Visit form declaration node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( FormDeclaration node, Context context );

	/**
	 * Visit question declaration node.
	 *
	 * @param node
	 * @param context
	 *
	 * @return The value.
	 */
	Value visit( QuestionDeclaration node, Context context );
}
