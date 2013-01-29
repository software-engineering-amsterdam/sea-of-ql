package org.uva.sea.ql.printer;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a pretty printer for expression nodes.
 */
public class ExpressionPrinter extends PrintVisitor implements IExpressionVisitor<Boolean> {
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
	public Boolean visit( LogicalExpression node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		decreaseLevel();

		return true;
	}

	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 */
	public Boolean visit( ArithmeticExpression node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		decreaseLevel();

		return true;
	}

	/**
	 * Visit unary logical expression.
	 *
	 * @param node
	 */
	public Boolean visit( UnaryExpression node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getExpression().accept( this );

		decreaseLevel();

		return true;
	}

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 */
	public Boolean visit( UnaryNumericExpression node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getExpression().accept( this );

		decreaseLevel();

		return true;
	}

	/**
	 * Visit comparison expression.
	 *
	 * @param node
	 */
	public Boolean visit( ComparisonExpression node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getLhs().accept( this );

		indent();
		node.getRhs().accept( this );

		decreaseLevel();

		return true;
	}


	@Override
	public Boolean visit( Str node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Money node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Int node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Bool node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Ident node ) {
		writeAtomic( node );
		return true;
	}

	@Override
	public Boolean visit( Add node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Sub node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Div node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Mul node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( And node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Boolean visit( Or node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Boolean visit( Eq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( GEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( GT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( LEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( LT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( NEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( Not node ) {
		return this.visit( (UnaryExpression) node );
	}

	@Override
	public Boolean visit( Pos node ) {
		return this.visit( (UnaryNumericExpression) node );
	}

	@Override
	public Boolean visit( Neg node ) {
		return this.visit( (UnaryNumericExpression) node );
	}
}
