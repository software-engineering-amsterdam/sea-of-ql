package khosrow.uva.sea.ql.visitor.eval;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.ReverseIterator;
import khosrow.uva.sea.ql.values.*;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class StmtEvaluator implements IStmtVisitor<Stmt> {
		private final Env env;
		
		private StmtEvaluator(Env env){
			this.env = env;
		}
		
		public static void Evaluate(Stmt stmt, Env env) {
			StmtEvaluator evaluater = new StmtEvaluator(env);
			stmt.accept(evaluater);
		}
		
		@Override
		public Stmt visit(Assign stmt) {
			Value valToAssign = evalExpression(stmt.getExpr());
			env.assignValue(stmt.getIdent(), valToAssign);
			return stmt;
		}

		@Override
		public Stmt visit(If stmt) {
			BoolVal cond =  (BoolVal)evalExpression(stmt.getCond());
			if(cond.getValue())
				stmt.getBody().accept(this);
			return stmt;
		}

		@Override
		public Stmt visit(ExpressionQuestion stmt) {			
			return stmt;
		}

		@Override
		public Stmt visit(SimpleQuestion stmt) {			
			return stmt;
		}

		@Override
		public Stmt visit(Label stmt) {
			return stmt;
		}

		@Override
		public Stmt visit(Stmts stmts) {	
			ReverseIterator<Stmt> rIter = new ReverseIterator<Stmt>(stmts.iterator());			
			while(rIter.hasNext()) 
				rIter.next().accept(this);		
			return stmts;
		}

		public Env getEnv() {
			return env;
		}
		
		private Value evalExpression(Expr expr) {
			return ExprEvaluator.Evaluate(expr, env);
		}	
		

}
