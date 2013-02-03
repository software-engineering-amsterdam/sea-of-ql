package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;

/**
 * Statement visitor.
 */
public interface IStatementVisitor<T> {
	/**
	 * Visit ELSE-IF-statement.
	 *
	 * @param node
	 */
	T visit( ElseIf node );

	/**
	 * Visit bunch of ELSE-IFS.
	 *
	 * @param node
	 */
	T visit( ElseIfs node );

	/**
	 * Visit IF-THEN-statement.
	 *
	 * @param node
	 */
	T visit( Else node );

	/**
	 * Visit IF-THEN-ELSE-statement.
	 *
	 * @param node
	 */
	T visit( IfThenElse node );

	/**
	 * Visit a variable declaration.
	 *
	 * @param node
	 */
	T visit( VarDeclaration node );

	/**
	 * Visit an assignment.
	 *
	 * @param node
	 */
	T visit( Assignment node );

	/**
	 * Visit form declaration node.
	 *
	 * @param node
	 */
	T visit( FormDeclaration node );

	/**
	 * Visit question declaration node.
	 *
	 * @param node
	 */
	T visit( QuestionDeclaration node );

	/**
	 * Visit statements node.
	 *
	 * @param node
	 */
	T visit( Statements node );
}
