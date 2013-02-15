package org.uva.sea.ql.visitor.evaluator;

import java.util.Set;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.binary.logical.AndExpression;
import org.uva.sea.ql.ast.expression.binary.logical.OrExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.LiteralExpression;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

class DependencyFinder implements ExpressionVisitor<Void> {
	private final Set<IdentifierExpression> dependencies;

	public static void findDependencies( Expression expression, Set<IdentifierExpression> dependencies ) {
		DependencyFinder finder = new DependencyFinder( dependencies );
		expression.accept( finder );
	}

	private DependencyFinder( Set<IdentifierExpression> dependencies ) {
		this.dependencies = dependencies;
	}

	private Void visitBinaryExpression( BinaryExpression node ) {
		node.getLhs().accept( this );
		node.getRhs().accept( this );
		return null;
	}

	private Void visitUnaryExpression( UnaryExpression node ) {
		node.getExpression().accept( this );
		return null;
	}

	private Void visitLiteralExpression( LiteralExpression node ) {
		return null;
	}

	@Override
	public Void visit( AddExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( SubtractExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( DivideExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( MultiplyExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( AndExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( OrExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( EqualExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( GreaterThanOrEqualExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( GreaterThanExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( LesserThanOrEqualExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( LesserThanExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( NotEqualExpression node ) {
		return this.visitBinaryExpression( node );
	}

	@Override
	public Void visit( NotExpression node ) {
		return this.visitUnaryExpression( node );
	}

	@Override
	public Void visit( PositiveExpression node ) {
		return this.visitUnaryExpression( node );
	}

	@Override
	public Void visit( NegativeExpression node ) {
		return this.visitUnaryExpression( node );
	}

	@Override
	public Void visit( IntegerLiteral node ) {
		return this.visitLiteralExpression( node );
	}

	@Override
	public Void visit( BooleanLiteral node ) {
		return this.visitLiteralExpression( node );
	}

	@Override
	public Void visit( MoneyLiteral node ) {
		return this.visitLiteralExpression( node );
	}

	@Override
	public Void visit( StringLiteral node ) {
		return this.visitLiteralExpression( node );
	}

	@Override
	public Void visit( IdentifierExpression node ) {
		this.dependencies.add( node );
		return null;
	}

}
