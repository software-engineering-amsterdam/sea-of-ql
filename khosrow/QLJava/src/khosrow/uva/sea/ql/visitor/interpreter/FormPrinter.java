package khosrow.uva.sea.ql.visitor.interpreter;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.stmt.Assign;
import khosrow.uva.sea.ql.ast.stmt.ExpressionQuestion;
import khosrow.uva.sea.ql.ast.stmt.If;
import khosrow.uva.sea.ql.ast.stmt.Label;
import khosrow.uva.sea.ql.ast.stmt.SimpleQuestion;
import khosrow.uva.sea.ql.ast.stmt.Stmt;
import khosrow.uva.sea.ql.ast.stmt.Stmts;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.ReverseIterator;
import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class FormPrinter implements IStmtVisitor<Void>{

	private final Env env;
	
	public FormPrinter(Env env){
		this.env = env;
	}	
	
	@Override
	public Void visit(Assign stmt) {
		Value valToAssign = evalExpression(stmt.getExpr());
		env.assignValue(stmt.getIdent(), valToAssign);
		return null;
	}

	@Override
	public Void visit(If stmt) {
		BoolVal cond =  (BoolVal)evalExpression(stmt.getCond());
		if(cond.getValue())
			stmt.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(ExpressionQuestion stmt) {
		BoolVal cond = (BoolVal)evalExpression(stmt.getExpr());
		if(cond.getValue())
			printResult(stmt.getText());
		return null;
	}

	@Override
	public Void visit(SimpleQuestion stmt) {
		printResult(stmt.getText());
		return null;
	}

	@Override
	public Void visit(Label stmt) {
		printResult(stmt.getText() + " Value: " + evalExpression(stmt.getExpr()).toString());
		return null;
	}

	@Override
	public Void visit(Stmts stmts) {	
		ReverseIterator<Stmt> rIter = new ReverseIterator<Stmt>(stmts.iterator());			
		while(rIter.hasNext()) 
			rIter.next().accept(this);		
		return null;
	}

	public Env getEnv() {
		return env;
	}
	
	private Value evalExpression(Expr expr) {
		return ExprEvaluator.Evaluate(expr, env);
	}
	
	private void printResult(String message) {
		System.out.println(message);
	}
}
