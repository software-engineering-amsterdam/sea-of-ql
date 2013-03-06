package khosrow.uva.sea.ql.visitor.eval;

import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlDeclarationError;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class DeclEvaluator implements IStmtVisitor<Boolean> {
	private final Env env;
	private List<QlDeclarationError> declarationErros;

	private DeclEvaluator(Env env, List<QlDeclarationError> declarationErros) {
		this.env = env;
		this.declarationErros = declarationErros;
	}
	
	public static boolean Evaluate(Stmt stmt, Env env, List<QlDeclarationError> declarationErros) {
		DeclEvaluator evaluator = new DeclEvaluator(env, declarationErros);
		return stmt.accept(evaluator);
	
	}
	@Override
	public Boolean visit(Assign stmt) {
		// will be handled by 
		// the statement evaluator
		return true;
	}

	@Override
	public Boolean visit(If stmt) {
		return stmt.getBody().accept(this);
	}

	@Override
	public Boolean visit(ExpressionQuestion stmt) {
		return DeclareQuestion(stmt);
	}

	@Override
	public Boolean visit(SimpleQuestion stmt) {
		return DeclareQuestion(stmt);
	}

	@Override
	public Boolean visit(Label stmt) {
		return DeclareLabel(stmt);
	}

	@Override
	public Boolean visit(Stmts stmts) {
		int countErrors = 0;
		for(Stmt statement: stmts) {
			if(!statement.accept(this))
				countErrors++;
		}
		return countErrors == 0;		
	}
	
	private boolean DeclareQuestion(Question stmt) {
		Ident ident = stmt.getIdent();
		if(env.lookUpIdent(ident)) {
			addToErrorList(stmt, ident.getName() + " is already used in another declaration.");
			return false;
		}
		env.declareType(ident, stmt.getType());
		return true;
	}
	
	private boolean DeclareLabel(Label stmt) {
		Ident ident = stmt.getIdent();
		if(env.lookUpIdent(ident)) {
			addToErrorList(stmt, ident.getName() + " is internally in use. Define another name.");
			return false;
		}
		env.declareType(ident, stmt.getType());
		return true;
	}
		
	private void addToErrorList(ASTNode ast, String message) {
		declarationErros.add(new QlDeclarationError("Declaration error at node " + 
			ast.getClass() + ". Message: " + message));		
	}
}
