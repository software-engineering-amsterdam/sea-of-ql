package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;

public class Eval implements ExpressionVisitor<Value> {

	private final ValueEnvironment env;
	
	public Eval(ValueEnvironment env) {
		this.env = env; //Collections.unmodifiableMap(env);
	}
	
	public Value visit(Add expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.add(r);
	}

	public Value visit(Div expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.div(r);
	}
	
	public Value visit(Mul expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.mul(r);
	}
	
	public Value visit(Neg expr) {
		Value v = expr.getOperand().accept(this);
		return v.neg();
	}
	
	public Value visit(Pos expr) {
		Value v = expr.getOperand().accept(this);
		return v.pos();
	}
	
	public Value visit(Sub expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.sub(r);
	}
	
	public Value visit(And expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.and(r);
	}
	
	public Value visit(Not expr) {
		Value v = expr.getOperand().accept(this);
		return v.not();
	}
	
	public Value visit(Or expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.or(r);
	}

	public Value visit(Eq expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.eq(r);
	}

	public Value visit(GEq expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.geq(r);
	}

	public Value visit(GT expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.gt(r);
	}

	public Value visit(LEq expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.leq(r);
	}

	public Value visit(LT expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.lt(r);
	}

	public Value visit(NEq expr) {
		Value l = expr.getLeftOperand().accept(this);
		Value r = expr.getRightOperand().accept(this);
		return l.neq(r);
	}

	public Value visit(Identifier var) {
		return env.getValue(var);
	}

	public Value visit(BooleanLiteral expr) {
		return new BooleanValue(expr.getValue());
	}

	public Value visit(IntegerLiteral expr) {
		return new IntegerValue(expr.getValue());
	}

	public Value visit(StringLiteral expr) {
		return new StringValue(expr.getValue());
	}

	public Value visit(MoneyLiteral expr) {
		return new MoneyValue(expr.getValue());
	}
	
}
