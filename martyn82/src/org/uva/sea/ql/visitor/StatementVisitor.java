package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;

public interface StatementVisitor<T> {
	T visit( IfThen node );
	T visit( IfThenElse node );
	T visit( Statements node );
	T visit( VariableDeclaration node );
	T visit( Assignment node );
	T visit( FormDeclaration node );
	T visit( VariableQuestion node );
	T visit( ComputedQuestion node );
}
