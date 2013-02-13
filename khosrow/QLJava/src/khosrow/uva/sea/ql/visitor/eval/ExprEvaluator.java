package khosrow.uva.sea.ql.visitor.eval;

import khosrow.uva.sea.ql.ast.expr.*;
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
		return lhsVal.add(rhsVal);
	}
	
	@Override
	public Value visit(Sub ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.sub(rhsVal);
	}
	
	@Override
	public Value visit(Div ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.div(rhsVal);
	}
	
	@Override
	public Value visit(Mod ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.mod(rhsVal);
	}

	@Override
	public Value visit(Mul ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.mul(rhsVal);
	}

	@Override
	public Value visit(Neg ast) {
		Value argVal = ast.getArg().accept(this);
		return argVal.neg();
	}

	@Override
	public Value visit(And ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.and(rhsVal);
	}	

	@Override
	public Value visit(Eq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.eq(rhsVal);
	}

	@Override
	public Value visit(GEq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.geq(rhsVal);
	}

	@Override
	public Value visit(GT ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.gt(rhsVal);
	}

	@Override
	public Value visit(Ident ast) {
		return valueEnv.valueOf(ast);
	}

	@Override
	public Value visit(LEq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.leq(rhsVal);
	}

	@Override
	public Value visit(LT ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.lt(rhsVal);
	}

	@Override
	public Value visit(NEq ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.neq(rhsVal);
	}

	@Override
	public Value visit(Not ast) {
		Value argVal = ast.getArg().accept(this);
		return argVal.not();
	}

	@Override
	public Value visit(Or ast) {
		Value lhsVal = ast.getLhs().accept(this);
		Value rhsVal = ast.getRhs().accept(this);
		return lhsVal.or(rhsVal);
	}

	@Override
	public Value visit(Pos ast) {
		Value argVal = ast.getArg().accept(this);
		return argVal.pos();
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
