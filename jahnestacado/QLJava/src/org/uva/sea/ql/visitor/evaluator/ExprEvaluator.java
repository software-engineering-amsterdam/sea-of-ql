package org.uva.sea.ql.visitor.evaluator;



import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.algebraic.Add;
import org.uva.sea.ql.ast.expr.binary.algebraic.Div;
import org.uva.sea.ql.ast.expr.binary.algebraic.Mul;
import org.uva.sea.ql.ast.expr.binary.algebraic.Sub;
import org.uva.sea.ql.ast.expr.binary.bool.And;
import org.uva.sea.ql.ast.expr.binary.bool.Eq;
import org.uva.sea.ql.ast.expr.binary.bool.GEq;
import org.uva.sea.ql.ast.expr.binary.bool.GT;
import org.uva.sea.ql.ast.expr.binary.bool.LEq;
import org.uva.sea.ql.ast.expr.binary.bool.LT;
import org.uva.sea.ql.ast.expr.binary.bool.NEq;
import org.uva.sea.ql.ast.expr.binary.bool.Or;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.visitor.IExprVisitor;
import org.uva.sea.ql.visitor.evaluator.values.BoolValue;
import org.uva.sea.ql.visitor.evaluator.values.DecValue;
import org.uva.sea.ql.visitor.evaluator.values.IntValue;
import org.uva.sea.ql.visitor.evaluator.values.StrValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class ExprEvaluator implements IExprVisitor<org.uva.sea.ql.visitor.evaluator.values.Value> {
	
	private final Map<String, org.uva.sea.ql.visitor.evaluator.values.Value> runTimeValues;
	
	private ExprEvaluator(Map<String, org.uva.sea.ql.visitor.evaluator.values.Value> runTimeValues2){
		this.runTimeValues=Collections.unmodifiableMap(runTimeValues2);
	}

	public static Value eval(Expr expr,Map<String, org.uva.sea.ql.visitor.evaluator.values.Value> runTimeValues2){
		ExprEvaluator evaluator=new ExprEvaluator(runTimeValues2);
		return expr.accept(evaluator);
		
	}
	
	
	//** Binary exprs
	
	@Override 
	public Value visit(Add node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new DecValue(((DecValue)left).getValue() + ((DecValue)right).getValue());
		}
		return new IntValue(((IntValue)left).getValue() + ((IntValue)right).getValue());
	}
	
	@Override
	public Value visit(Div node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new DecValue(((DecValue)left).getValue() / ((DecValue)right).getValue());
		}
		return new IntValue(((IntValue)left).getValue() / ((IntValue)right).getValue());
	}

	@Override
	public Value visit(Sub node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new DecValue(((DecValue)left).getValue() - ((DecValue)right).getValue());
		}
		return new IntValue(((IntValue)left).getValue() - ((IntValue)right).getValue());
	}
	
	@Override
	public Value visit(Mul node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new DecValue(((DecValue)left).getValue() * ((DecValue)right).getValue());
		}
		return new IntValue(((IntValue)left).getValue() * ((IntValue)right).getValue());
	}
	
	//** Logical Exprs
	
	@Override
	public Value visit(And node) {
		Value left = node.getLeftExpr().accept(this);
		if (!( (BoolValue) left).getValue()) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}
	
	@Override
	public Value visit(Or node) {
		Value left = node.getLeftExpr().accept(this);
		if (((BoolValue) left).getValue()) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}

	//** Comparison Exprs
	
	@Override
	public Value visit(Eq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() == ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() == ((IntValue)right).getValue());
	}

	@Override
	public Value visit(GEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() >= ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() >= ((IntValue)right).getValue());
	}

	@Override
	public Value visit(GT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() > ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() > ((IntValue)right).getValue());
	}

	@Override
	public org.uva.sea.ql.visitor.evaluator.values.Value visit(Ident node) {
		return runTimeValues.get(node.getName());
	}

	@Override
	public Value visit(LEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() <= ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() <= ((IntValue)right).getValue());
	}

	@Override
	public Value visit(LT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() < ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() < ((IntValue)right).getValue());
	}

	

	@Override
	public Value visit(NEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		if(left.isDecValue()){
			return new BoolValue(((DecValue)left).getValue() != ((DecValue)right).getValue());
		}
		return new BoolValue(((IntValue)left).getValue() != ((IntValue)right).getValue());
	}

	//** Unary Exprs
	@Override
	public Value visit(Neg node) {
		Value operand=node.getLeftExpr().accept(this);
		if(operand.isDecValue()){
			return new DecValue(- ((DecValue)operand).getValue());
		}
		return new IntValue(- ((IntValue)operand).getValue());
	}
	
	@Override
	public Value visit(Not node) {
		Value operand=node.getLeftExpr().accept(this);		
		return new BoolValue(!((BoolValue)operand).getValue());

	}

	

	@Override
	public Value visit(Pos node) {
		return node.getLeftExpr().accept(this);
	}

	

	@Override
	public Value visit(IntegerLit node) {
		return new IntValue(node.getValue());
	}

	@Override
	public Value visit(BoolLit node) {
		return new BoolValue(node.getValue());
	}

	@Override
	public Value visit(DecimalLit node) {
		return new DecValue(node.getValue());
	}

	@Override
	public Value visit(StringLit node) {
		return new StrValue(node.getValue());
	}





	



}
