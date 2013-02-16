package khosrow.uva.sea.ql.visitor.interpreter;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class SwingStmtInterpreter implements IStmtVisitor<Void> {
	private final Env env;
	
	public SwingStmtInterpreter(Env env){
		this.env = env;
	}
	
	public static void Evaluate(Stmt stmt, Env env) {
		SwingStmtInterpreter evaluater = new SwingStmtInterpreter(env);
		stmt.accept(evaluater);
	}
	
	@Override
	public Void visit(Assign stmt) {
		Value valToAssign = evaluateExpression(stmt.getExpr());
		env.assignValue(stmt.getIdent(), valToAssign);
		return null;
	}

	@Override
	public Void visit(If stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ExpressionQuestion stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(SimpleQuestion stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Label stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Stmts stmts) {
		// TODO Auto-generated method stub
		return null;
	}

	public Env getEnv() {
		return env;
	}
	
	private Value evaluateExpression(Expr expr) {
		return ExprEvaluator.Evaluate(expr, env);
	}

}
