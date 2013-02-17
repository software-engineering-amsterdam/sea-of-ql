package org.uva.sea.ql.visitors;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.visitors.interfaces.IExprVisitor;

public class ExprEvaluator implements IExprVisitor<Value> {

	private final Map<String, Value> env;

	public ExprEvaluator(Map<String, Value> env) {
		this.env = Collections.unmodifiableMap(env);
	}

	@Override
	public Value visit(Add node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.add(rhs);
	}

	@Override
	public Value visit(Sub node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.sub(rhs);
	}

	@Override
	public Value visit(Div node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.div(rhs);
	}

	@Override
	public Value visit(Mul node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.mul(rhs);
	}

	@Override
	public Value visit(And node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.and(rhs);
	}

	@Override
	public Value visit(Or node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.or(rhs);
	}

	@Override
	public Value visit(Eq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.eq(rhs);
	}

	@Override
	public Value visit(GEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.geq(rhs);
	}

	@Override
	public Value visit(GT node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.gt(rhs);
	}

	@Override
	public Value visit(LEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.leq(rhs);
	}

	@Override
	public Value visit(LT node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.lt(rhs);
	}

	@Override
	public Value visit(NEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.neq(rhs);
	}

	@Override
	public Value visit(Not node) {
		Value value = node.getArg().accept(this);
		return value.not();
	}

	@Override
	public Value visit(Pos node) {
		Value value = node.getArg().accept(this);
		return value.pos();
	}

	@Override
	public Value visit(Neg node) {
		Value value = node.getArg().accept(this);
		return value.neg();
	}

	@Override
	public Value visit(Ident node) {
		if (env.containsKey(node.getName())) {
			return env.get(node.getName());
		}
		return null;
	}

	@Override
	public Value visit(IntLiteral node) {
		return new IntLiteral(node.getValue());
	}

	@Override
	public Value visit(BoolLiteral node) {
		return new BoolLiteral(node.getValue());
	}

	@Override
	public Value visit(MoneyLiteral node) {
		return new MoneyLiteral(node.getValue());
	}

	@Override
	public Value visit(StringLiteral node) {
		return new StringLiteral(node.getValue());
	}

}
