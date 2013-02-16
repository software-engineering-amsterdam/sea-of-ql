package khosrow.uva.sea.ql.visitor.eval;

import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlDeclarationError;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class DeclEvaluator implements IStmtVisitor<Boolean> {
	private final Env env;
	private List<QlDeclarationError> messages;

	private DeclEvaluator(Env env, List<QlDeclarationError> messages) {
		this.env = env;
		this.messages = messages;
	}
	
	public static boolean Evaluate(Form form, Env env, List<QlDeclarationError> messages) {
		DeclEvaluator evaluator = new DeclEvaluator(env, messages);
		return form.getStmts().accept(evaluator);
	
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
		// will be handled by 
		// the statement evaluator
		return true;
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
	
	private void addToErrorList(ASTNode ast, String message) {
		messages.add(new QlDeclarationError("Declaration error at node " + 
			ast.getClass() + ". Message: " + message));		
	}
}
