package org.uva.sea.ql.interpreter;



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
import org.uva.sea.ql.ast.expr.values.Decimal;
import org.uva.sea.ql.ast.expr.values.Int;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.visitor.IExprVisitor;
@SuppressWarnings("rawtypes")
public class ExprEvaluator implements IExprVisitor<Value> {

	public static Value eval(Expr expr){
		ExprEvaluator evaluator=new ExprEvaluator();
		return expr.accept(evaluator);
		
	}
	
	
	//** Binary exprs
	
	@Override 
	public Value visit(Add node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new Decimal(((Decimal)left).getValue() + ((Decimal)right).getValue());
		}
		return new Int(((Int)left).getValue() + ((Int)right).getValue());
	}
	
	@Override
	public Value visit(Div node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new Decimal(((Decimal)left).getValue() / ((Decimal)right).getValue());
		}
		return new Int(((Int)left).getValue() / ((Int)right).getValue());
	}

	@Override
	public Value visit(Sub node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new Decimal(((Decimal)left).getValue() - ((Decimal)right).getValue());
		}
		return new Int(((Int)left).getValue() - ((Int)right).getValue());
	}
	
	@Override
	public Value visit(Mul node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new Decimal(((Decimal)left).getValue() * ((Decimal)right).getValue());
		}
		return new Int(((Int)left).getValue() * ((Int)right).getValue());
	}
	
	//** Logical Exprs
	
	@Override
	public Value visit(And node) {
		Value left = node.getLeftExpr().accept(this);
		if (!((Boolean) left.getValue())) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}
	
	@Override
	public Value visit(Or node) {
		Value left = node.getLeftExpr().accept(this);
		if ((Boolean) left.getValue()) {
			return left;
		}

		return node.getRightExpr().accept(this);
	}

	//** Comparison Exprs
	
	@Override
	public Value visit(Eq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() == ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() == ((Int)right).getValue());
	}

	@Override
	public Value visit(GEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() >= ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() >= ((Int)right).getValue());
	}

	@Override
	public Value visit(GT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() > ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() > ((Int)right).getValue());
	}

	@Override
	public Value visit(Ident node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() <= ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() <= ((Int)right).getValue());
	}

	@Override
	public Value visit(LT node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() < ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() < ((Int)right).getValue());
	}

	

	@Override
	public Value visit(NEq node) {
		Value left=node.getLeftExpr().accept(this);
		Value right=node.getRightExpr().accept(this);
		String exprType=left.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new BoolLit(((Decimal)left).getValue() != ((Decimal)right).getValue());
		}
		return new BoolLit(((Int)left).getValue() != ((Int)right).getValue());
	}

	//** Unary Exprs
	@Override
	public Value visit(Neg node) {
		Value operand=node.getLeftExpr().accept(this);
		String exprType=operand.isOfType(null).getClass().getSimpleName();
		if(exprType.equals("MoneyType")){
			return new Decimal(- ((Decimal)operand).getValue());
		}
		return new Int(- ((Int)operand).getValue());
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
	public Value visit(Int node) {
		return node;
	}

	@Override
	public Value visit(BoolLit node) {
		return node;
	}

	@Override
	public Value visit(Decimal node) {
		return node;
	}

	@Override
	public Value visit(StringLit node) {
		return node;
	}



}
