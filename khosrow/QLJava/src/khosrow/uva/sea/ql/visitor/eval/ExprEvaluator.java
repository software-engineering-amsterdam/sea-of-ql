package khosrow.uva.sea.ql.visitor.eval;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.*;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class ExprEvaluator implements IExprVisitor<IValue> {
	private final Env valueEnv;
	
	public ExprEvaluator(Env valueEnv) {
		this.valueEnv = valueEnv;
	}
	
	public static IValue Evaluate(Expr expr, Env valueEnv) {
		ExprEvaluator evaluater = new ExprEvaluator(valueEnv);
		return expr.accept(evaluater);
	}
	
	@Override
	public IValue visit(Add ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if (lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() + ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() + ((IntVal)rhsVal).getValue());
	}

	@Override
	public IValue visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(Div ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() / ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() / ((IntVal)rhsVal).getValue());
	}

	@Override
	public IValue visit(Eq ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult == 0);
	}

	@Override
	public IValue visit(GEq ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult >= 0);
	}

	@Override
	public IValue visit(GT ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult > 0);
	}

	@Override
	public IValue visit(Ident ast) {
		return valueEnv.valueOf(ast);
	}

	@Override
	public IValue visit(LEq ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult <= 0);
	}

	@Override
	public IValue visit(LT ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		int compResult = lhsVal.compareTo(rhsVal);
		return new BoolVal(compResult < 0);
	}

	@Override
	public IValue visit(Mod ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() % ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() % ((IntVal)rhsVal).getValue());
	}

	@Override
	public IValue visit(Mul ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() * ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() * ((IntVal)rhsVal).getValue());
	}

	@Override
	public IValue visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue visit(Sub ast) {
		IValue lhsVal = ast.getLhs().accept(this);
		IValue rhsVal = ast.getRhs().accept(this);
		Type lhsType = ast.getLhs().typeOf(valueEnv);
		Type rhsType = ast.getRhs().typeOf(valueEnv);
		
		if(lhsType instanceof Money || rhsType instanceof Money)
			return new MoneyVal(((NumericVal)lhsVal).convertToMoneyVal() - ((NumericVal)rhsVal).convertToMoneyVal());
		return new IntVal(((IntVal)lhsVal).getValue() - ((IntVal)rhsVal).getValue());
	}

	@Override
	public IValue visit(IntLiteral ast) {
		return new IntVal(ast.getValue());
	}

	@Override
	public IValue visit(BoolLiteral ast) {
		return new BoolVal(ast.getValue());
	}

	@Override
	public IValue visit(MoneyLiteral ast) {
		return new MoneyVal(ast.getValue());
	}

	@Override
	public IValue visit(StringLiteral ast) {
		return new StrVal(ast.getValue());
	}

	public Env getValueEnv() {
		return valueEnv;
	}


}
