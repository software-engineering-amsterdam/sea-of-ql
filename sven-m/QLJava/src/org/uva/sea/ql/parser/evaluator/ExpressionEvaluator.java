package org.uva.sea.ql.parser.evaluator;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BoolLiteral;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.IntLiteral;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.StrLiteral;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;
import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class ExpressionEvaluator implements ExpressionVisitor<Value> {
	private final Map<Ident, Value> symbolTable;

	public ExpressionEvaluator(Map<Ident, Value> symbolTable) {
		this.symbolTable = new HashMap<>(symbolTable);
	}

	@Override
	public Value visit(Add ast) {
		return ast.getLhs().accept(this).add(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Sub ast) {
		return ast.getLhs().accept(this).sub(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Mul ast) {
		return ast.getLhs().accept(this).mul(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Div ast) {
		return ast.getLhs().accept(this).div(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(And ast) {
		return ast.getLhs().accept(this).and(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Or ast) {
		return ast.getLhs().accept(this).or(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(LT ast) {
		return ast.getLhs().accept(this).lt(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(LEq ast) {
		return ast.getLhs().accept(this).leq(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Eq ast) {
		return ast.getLhs().accept(this).eq(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(NEq ast) {
		return ast.getLhs().accept(this).neq(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(GEq ast) {
		return ast.getLhs().accept(this).geq(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(GT ast) {
		return ast.getLhs().accept(this).gt(ast.getRhs().accept(this));
	}

	@Override
	public Value visit(Pos ast) {
		return ast.getOp().accept(this).pos();
	}

	@Override
	public Value visit(Neg ast) {
		return ast.getOp().accept(this).neg();
	}

	@Override
	public Value visit(Not ast) {
		return ast.getOp().accept(this).not();
	}

	@Override
	public Value visit(Ident ast) {
		if (symbolTable.containsKey(ast)) {
			assert symbolTable.get(ast) != null: "Null in sytmboltable";
			return symbolTable.get(ast);
		}

		return new UndefinedValue();
	}

	@Override
	public Value visit(IntLiteral ast) {
		return new IntValue(ast.getValue());
	}

	@Override
	public Value visit(StrLiteral ast) {
		return new StrValue(ast.getValue());
	}

	@Override
	public Value visit(BoolLiteral ast) {
		return new BoolValue(ast.getValue());
	}

}
