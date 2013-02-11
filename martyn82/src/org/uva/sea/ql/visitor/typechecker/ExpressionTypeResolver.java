package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
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
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumberType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

public class ExpressionTypeResolver implements ExpressionVisitor<Type> {
	private final Environment environment;

	public ExpressionTypeResolver( Environment environment ) {
		this.environment = environment;
	}

	private Type visitArithmetic( ArithmeticExpression node ) {
		return NumberType.NUMBER;
	}

	private Type visitLogical( LogicalExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitComparison( ComparisonExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnary( UnaryExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnaryNumeric( UnaryNumericExpression node ) {
		return NumberType.NUMBER;
	}

	@Override
	public Type visit( Int node ) {
		return IntegerType.INTEGER;
	}

	@Override
	public Type visit( Bool node ) {
		return BooleanType.BOOLEAN;
	}

	@Override
	public Type visit( Money node ) {
		return MoneyType.MONEY;
	}

	@Override
	public Type visit( Str node ) {
		return StringType.STRING;
	}

	@Override
	public Type visit( Ident node ) {
		if ( this.environment.isDeclared( node ) ) {
			return this.environment.lookupType( node );
		}

		return new UndefinedType();
	}

	@Override
	public Type visit( Add node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Sub node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Div node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Mul node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( And node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( Or node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( Eq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( NEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( Not node ) {
		return this.visitUnary( node );
	}

	@Override
	public Type visit( Pos node ) {
		return this.visitUnaryNumeric( node );
	}

	@Override
	public Type visit( Neg node ) {
		return this.visitUnaryNumeric( node );
	}
}
