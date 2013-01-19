package org.uva.sea.ql.visitor.typecheck;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.value.Literal;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeChecker implements INodeVisitor {

	@Override
	public void visit( ArithmeticExpression node ) {
		Type left = ( (Literal) node.getLhs() ).accept( this );
		Type right = ( (Literal) node.getRhs() ).accept( this );

		if (
			!(
				left instanceof org.uva.sea.ql.ast.type.Number
				&& right instanceof org.uva.sea.ql.ast.type.Number
			)
		) {
			System.err.println( "Both sides should be a number type." );
		}
	}

	@Override
	public void visit( LogicalExpression node ) {
		Type left = ( (Literal) node.getLhs() ).accept( this );
		Type right = ( (Literal) node.getRhs() ).accept( this );

		if (
			!(
				left instanceof org.uva.sea.ql.ast.type.Bool
				&& right instanceof org.uva.sea.ql.ast.type.Bool
			)
		) {
			System.err.println( "Both sides should be a boolean type." );
		}
	}

	@Override
	public void visit( BinaryExpression node ) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit( UnaryExpression node ) {
		Type expression = ( (Literal) node.getExpression() ).accept( this );

		if ( !( expression instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			System.err.println( "Expression must be a boolean type." );
		}
	}

	@Override
	public void visit( UnaryNumericExpression node ) {
		Type expression = ( (Literal) node.getExpression() ).accept( this );

		if ( !( expression instanceof org.uva.sea.ql.ast.type.Number ) ) {
			System.err.println( "Expression must be a number type." );
		}
	}

	@Override
	public void visit( Literal node ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit( Ident node ) {
	}

	@Override
	public void visit( IfThenElse node ) {
		Type condition = ( (Literal) node.getCondition() ).accept( this );

		if ( !( condition instanceof Bool ) ) {
			System.err.println( "Condition of an IF block should evaluate to a boolean." );
		}

		if ( node.getIfThen() != null ) {
			node.getIfThen().accept( this );
		}

		if ( node.getIfElse() != null ) {
			node.getIfElse().accept( this );
		}
	}

	@Override
	public void visit( VarDeclaration node ) {
	}

	@Override
	public void visit( Assignment node ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit( FormDeclaration node ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit( QuestionDeclaration node ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit( Type node ) {
		// TODO Auto-generated method stub
	}

}
