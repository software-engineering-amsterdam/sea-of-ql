package org.uva.sea.ql.interpreter;



import java.util.HashMap;
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
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class ExprEvaluator implements IExprVisitor<Value> {
	private final Map<String, Type> emptyMap=new HashMap<String, Type>();
	private final Map<String,Value> declaredVar;
	
	
	private ExprEvaluator(Map<String,Value > declaredVar){
		this.declaredVar=declaredVar;
		
	}

	public static Value eval(Expr expr,Map<String,Value > declaredVar){
		ExprEvaluator evaluator=new ExprEvaluator(declaredVar);
		return expr.accept(evaluator);
		
	}
	
	
	//** Binary exprs
	
	@Override 
	public Value visit(Add node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new DecimalLit(((DecimalLit)left).getValue() + ((DecimalLit)right).getValue());
		}
		return new IntegerLit(((IntegerLit)left).getValue() + ((IntegerLit)right).getValue());
	}
	
	@Override
	public Value visit(Div node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new DecimalLit(((DecimalLit)left).getValue() / ((DecimalLit)right).getValue());
		}
		return new IntegerLit(((IntegerLit)left).getValue() / ((IntegerLit)right).getValue());
	}

	@Override
	public Value visit(Sub node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new DecimalLit(((DecimalLit)left).getValue() - ((DecimalLit)right).getValue());
		}
		return new IntegerLit(((IntegerLit)left).getValue() - ((IntegerLit)right).getValue());
	}
	
	@Override
	public Value visit(Mul node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new DecimalLit(((DecimalLit)left).getValue() * ((DecimalLit)right).getValue());
		}
		return new IntegerLit(((IntegerLit)left).getValue() * ((IntegerLit)right).getValue());
	}
	
	//** Logical Exprs
	
	@Override
	public Value visit(And node) {
		Value left = node.getLeftExpr().accept(this);
		if (!( (BoolLit) left).getValue()) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}
	
	@Override
	public Value visit(Or node) {
		Value left = node.getLeftExpr().accept(this);
		if (((BoolLit) left).getValue()) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}

	//** Comparison Exprs
	
	@Override
	public Value visit(Eq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() == ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() == ((IntegerLit)right).getValue());
	}

	@Override
	public Value visit(GEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() >= ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() >= ((IntegerLit)right).getValue());
	}

	@Override
	public Value visit(GT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() > ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() > ((IntegerLit)right).getValue());
	}

	@Override
	public Value visit(Ident node) {
		return declaredVar.get(node.getName());
	}

	@Override
	public Value visit(LEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() <= ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() <= ((IntegerLit)right).getValue());
	}

	@Override
	public Value visit(LT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() < ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() < ((IntegerLit)right).getValue());
	}

	

	@Override
	public Value visit(NEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		boolean isMoneyCompatible=left.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new BoolLit(((DecimalLit)left).getValue() != ((DecimalLit)right).getValue());
		}
		return new BoolLit(((IntegerLit)left).getValue() != ((IntegerLit)right).getValue());
	}

	//** Unary Exprs
	@Override
	public Value visit(Neg node) {
		Value operand=node.getLeftExpr().accept(this);
		boolean isMoneyCompatible=operand.isOfType(emptyMap).isCompatibleToMoneyType();
		if(isMoneyCompatible){
			return new DecimalLit(- ((DecimalLit)operand).getValue());
		}
		return new IntegerLit(- ((IntegerLit)operand).getValue());
	}
	
	@Override
	public Value visit(Not node) {
		Value operand=node.getLeftExpr().accept(this);		
		return new BoolLit(!((BoolLit)operand).getValue());

	}

	

	@Override
	public Value visit(Pos node) {
		return node.getLeftExpr().accept(this);
	}

	

	@Override
	public Value visit(IntegerLit node) {
		return node;
	}

	@Override
	public Value visit(BoolLit node) {
		return node;
	}

	@Override
	public Value visit(DecimalLit node) {
		return node;
	}

	@Override
	public Value visit(StringLit node) {
		return node;
	}

	



}
