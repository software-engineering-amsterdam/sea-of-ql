package org.uva.sea.ql.printer;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.arithmetic.Div;
import org.uva.sea.ql.ast.expression.arithmetic.Mul;
import org.uva.sea.ql.ast.expression.arithmetic.Sub;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.comparison.GEq;
import org.uva.sea.ql.ast.expression.comparison.GT;
import org.uva.sea.ql.ast.expression.comparison.LEq;
import org.uva.sea.ql.ast.expression.comparison.LT;
import org.uva.sea.ql.ast.expression.comparison.NEq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * Represents a pretty printer for expression nodes.
 */
public class ExpressionPrinter extends PrintVisitor implements ExpressionVisitor<Boolean> {
	/**
	 * Constructs a new ExpressionPrinter instance.
	 *
	 * @param context
	 */
	public ExpressionPrinter( PrintContext context ) {
		super( context );
	}

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 */
	private Boolean visitBinary( BinaryExpression node ) {
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getLhs().accept( this );

		this.indent();
		node.getRhs().accept( this );

		this.decreaseLevel();

		return true;
	}

	/**
	 * Visit unary logical expression.
	 *
	 * @param node
	 */
	private Boolean visitUnary( UnaryExpression node ) {
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getExpression().accept( this );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( Str node ) {
		this.writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		this.writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		this.writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Bool node ) {
		this.writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Ident node ) {
		this.writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Add node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Sub node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Div node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Mul node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( And node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Or node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Eq node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( GEq node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( GT node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( LEq node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( LT node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( NEq node ) {
		return this.visitBinary( node );
	}

	@Override
	public Boolean visit( Not node ) {
		return this.visitUnary( node );
	}

	@Override
	public Boolean visit( Pos node ) {
		return this.visitUnary( node );
	}

	@Override
	public Boolean visit( Neg node ) {
		return this.visitUnary( node );
	}
}
