package org.uva.sea.ql.gui.observers;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.binaryexpr.Add;
import org.uva.sea.ql.ast.binaryexpr.And;
import org.uva.sea.ql.ast.binaryexpr.BinaryExpr;
import org.uva.sea.ql.ast.binaryexpr.Div;
import org.uva.sea.ql.ast.binaryexpr.Eq;
import org.uva.sea.ql.ast.binaryexpr.GEq;
import org.uva.sea.ql.ast.binaryexpr.GT;
import org.uva.sea.ql.ast.binaryexpr.LEq;
import org.uva.sea.ql.ast.binaryexpr.LT;
import org.uva.sea.ql.ast.binaryexpr.Mul;
import org.uva.sea.ql.ast.binaryexpr.NEq;
import org.uva.sea.ql.ast.binaryexpr.Or;
import org.uva.sea.ql.ast.binaryexpr.Sub;
import org.uva.sea.ql.ast.primaryexpr.Bool;
import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Int;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.unaryexpr.Neg;
import org.uva.sea.ql.ast.unaryexpr.Not;
import org.uva.sea.ql.ast.unaryexpr.Pos;
import org.uva.sea.ql.ast.unaryexpr.UnaryExpr;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.gui.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.value.ValueExpressionVisitor;

public class ValueExpressionObserver implements Observer, IExpressionVisitor<Boolean> {

	private Environment environment;
	private Value<?> value;
	private Expr expression;
	
	public ValueExpressionObserver(Environment envir, Value<?> v, Expr exp) {
		environment = envir;
		value = v;
		expression = exp;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Value<?> v = expression.accept(new ValueExpressionVisitor(environment));
		value.setValue(v.toString());
	}
	
	@Override
	public Boolean visit(Ident exp) {
		environment.getValueByID(exp).addObserver(this);
		return true;
	}

	@Override
	public Boolean visit(Add exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Div exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Mul exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Sub exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(And exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Eq exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(GEq exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(GT exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(LEq exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(LT exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(NEq exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Or exp) {
		return visitBinaryExpr(exp);
	}

	@Override
	public Boolean visit(Neg exp) {
		return visitUnaryExpr(exp);
	}

	@Override
	public Boolean visit(Pos exp) {
		return visitUnaryExpr(exp);
	}

	@Override
	public Boolean visit(Not exp) {
		return visitUnaryExpr(exp);
	}

	@Override
	public Boolean visit(Int exp) {
		return true;
	}

	@Override
	public Boolean visit(Str exp) {
		return true;
	}

	@Override
	public Boolean visit(Bool exp) {
		return true;
	}
	
	public boolean visitUnaryExpr(UnaryExpr exp) {
		return exp.getExpr().accept(this);
	}
	
	public boolean visitBinaryExpr(BinaryExpr exp) {
		return exp.getLeft().accept(this) && exp.getRight().accept(this);
	}

}
