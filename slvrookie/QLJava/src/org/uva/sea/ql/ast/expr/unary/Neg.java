package org.uva.sea.ql.ast.expr.unary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IExprVisitor;

public class Neg extends UnaryExpr {

	public Neg(Expr arg) {
		super(arg);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		if (this.getArg().typeOf(typeEnv).isCompatibleToIntType()) {
			return new IntType();
		}
		if (this.getArg().typeOf(typeEnv).isCompatibleToMoneyType()) {
			return new MoneyType();
		}
		return new Numeric();
	}
	
	/*
	 * Same reason for Numeric as Binary Arithmetic expression
	 * but only for one argument.
	 */

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

}
