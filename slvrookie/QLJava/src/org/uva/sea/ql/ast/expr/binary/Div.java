package org.uva.sea.ql.ast.expr.binary;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.IExprVisitor;

public class Div extends BinaryExpr {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		if (this.getLhs().typeOf(typeEnv).isCompatibleToIntType()&& this.getRhs().typeOf(typeEnv).isCompatibleToIntType()) {
			return new IntType();
		}
		if (this.getLhs().typeOf(typeEnv).isCompatibleToMoneyType()&& this.getRhs().typeOf(typeEnv).isCompatibleToMoneyType()) {
			return new MoneyType();
		}
		return new Numeric();
	}
	
	/* 
	 * When typechecking non-leaf nodes if the types are not consistent return a numeric type.
	 * The TypeChecker will identify the inconsistency -if any- when it checks an expression consisted
	 * of leaf nodes.
	 * Ex. (2-3.00) + 3  return Numeric + IntType and let the TypeChecker
	 * catch the IntType-MoneyType inconsistency when it visits the (2-3.00) node.
	 */

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

}
