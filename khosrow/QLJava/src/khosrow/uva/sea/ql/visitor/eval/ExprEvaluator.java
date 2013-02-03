package khosrow.uva.sea.ql.visitor.eval;


import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.*;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class ExprEvaluator implements IExprVisitor<Value> {
	private final Env valueEnv;
	
	public ExprEvaluator(Env valueEnv) {
		this.valueEnv = valueEnv;
	}
	
	public static Value Evaluate(Expr expr, Env valueEnv) {
		ExprEvaluator evaluater = new ExprEvaluator(valueEnv);
		return expr.accept(evaluater);
	}
	
	@Override
	public Value visit(Add ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if (lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() + ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() + ((IntVal)rhsVal).getValue());
	}

	@Override
	public Value visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() / ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() / ((IntVal)rhsVal).getValue());
	}

	@Override
	public Value visit(Eq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult == 0);
	}

	@Override
	public Value visit(GEq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult >= 0);
	}

	@Override
	public Value visit(GT ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult > 0);
	}

	@Override
	public Value visit(Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult <= 0);
	}

	@Override
	public Value visit(LT ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult < 0);
	}

	@Override
	public Value visit(Mod ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() % ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() % ((IntVal)rhsVal).getValue());
	}

	@Override
	public Value visit(Mul ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() * ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() * ((IntVal)rhsVal).getValue());
	}

	@Override
	public Value visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() - ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() - ((IntVal)rhsVal).getValue());
	}

	@Override
	public Value visit(IntLiteral ast) {
		return new IntVal(ast.getValue());
	}

	@Override
	public Value visit(BoolLiteral ast) {
		return new BoolVal(ast.getValue());
	}

	@Override
	public Value visit(MoneyLiteral ast) {
		return new MoneyVal(ast.getValue());
	}

	@Override
	public Value visit(StringLiteral ast) {
		return new StrVal(ast.getValue());
	}

	public Env getValueEnv() {
		return valueEnv;
	}


}
