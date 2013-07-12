package org.uva.sea.ql.visitor.value;

import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.value.*;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.gui.Environment;

public class ValueExpressionVisitor implements IExpressionVisitor<Value<?>> {
	private Environment environment = new Environment();
	
	public ValueExpressionVisitor(Environment env) {
		environment = env;
	}

	@Override
	public IntValue visit(Add exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new IntValue(left.getValue() + right.getValue());
	}

	@Override
	public IntValue visit(Div exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new IntValue(left.getValue() / right.getValue());
	}

	@Override
	public IntValue visit(Mul exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new IntValue(left.getValue() * right.getValue());
	}

	@Override
	public IntValue visit(Sub exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new IntValue(left.getValue() - right.getValue());
	}

	@Override
	public BoolValue visit(And exp) {
		BoolValue left = (BoolValue)exp.getLeft().accept(this);
		BoolValue right = (BoolValue)exp.getRight().accept(this);
		
		return new BoolValue(left.getValue() && right.getValue());
	}

	@Override
	public BoolValue visit(Eq exp) {
		Value<?> left = exp.getLeft().accept(this);
		Value<?> right = exp.getRight().accept(this);
		
		return new BoolValue(left.getValue() == right.getValue());
	}

	@Override
	public BoolValue visit(GEq exp) {
		Eq eqExpr = new Eq(exp.getLeft(), exp.getRight());
		GT gtExpr = new GT(exp.getLeft(), exp.getRight());
		Or orExpr = new Or(gtExpr, eqExpr);
		
		return visit(orExpr);
	}

	@Override
	public BoolValue visit(GT exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new BoolValue(left.getValue() > right.getValue());
	}

	@Override
	public BoolValue visit(LEq exp) {
		Eq eqExpr = new Eq(exp.getLeft(), exp.getRight());
		LT ltExpr = new LT(exp.getLeft(), exp.getRight());
		Or orExpr = new Or(eqExpr, ltExpr);
		
		return visit(orExpr);
	}

	@Override
	public BoolValue visit(LT exp) {
		IntValue left = (IntValue)exp.getLeft().accept(this);
		IntValue right = (IntValue)exp.getRight().accept(this);
		
		return new BoolValue(left.getValue() < right.getValue());
	}

	@Override
	public BoolValue visit(NEq exp) {
		Eq eqExpr = new Eq(exp.getLeft(), exp.getRight());
		
		return visit(new Not(eqExpr));
	}

	@Override
	public BoolValue visit(Or exp) {
		BoolValue left = (BoolValue)exp.getLeft().accept(this);
		BoolValue right = (BoolValue)exp.getLeft().accept(this);
		
		return new BoolValue(left.getValue() || right.getValue());
	}

	@Override
	public IntValue visit(Neg exp) {
		IntValue i = (IntValue)exp.getExpr().accept(this);
		
		return new IntValue(0-i.getValue());
	}

	@Override
	public IntValue visit(Pos exp) {
		IntValue i = (IntValue)exp.getExpr().accept(this);
		
		return new IntValue(i.getValue());
	}

	@Override
	public BoolValue visit(Not exp) {
		BoolValue b = (BoolValue)exp.getExpr().accept(this);
		
		return new BoolValue(!b.getValue());
	}

	@Override
	public Value<?> visit(Ident exp) {
		if (!environment.containsKey(exp))
			return null;
		
		return environment.getValueByID(exp);
	}

	@Override
	public IntValue visit(Int exp) {
		return new IntValue(exp.getValue());
	}

	@Override
	public StrValue visit(Str exp) {
		return new StrValue(exp.getValue());
	}

	@Override
	public BoolValue visit(Bool exp) {
		return new BoolValue(exp.getValue());
	}

}
