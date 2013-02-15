package khosrow.uva.sea.ql.visitor.check;

import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.stmt.*;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class StmtTypeChecker implements IStmtVisitor<Boolean> {
	private final Env env;
	private final List<QlTypeError> messages;	
		
	public StmtTypeChecker(Env env, List<QlTypeError> messages) {
		this.env =  env;
		this.messages = messages;
	}
	
	public static boolean Check(Stmt stmt, Env env, List<QlTypeError> messages) {
		StmtTypeChecker checker = new StmtTypeChecker(env, messages);
		return stmt.accept(checker);
	}

	@Override
	public Boolean visit(Assign stmt) {
		return checkTypes(stmt.getIdent(), stmt.exprTypeOf(env))	&& 
			checkExpr(stmt.getExpr());
	}

	@Override
	public Boolean visit(If stmt) {
		return checkExpr(stmt.getCond()) &&
			checkIfBody(stmt.getBody());
	}	

	@Override
	public Boolean visit(ExpressionQuestion stmt) {		
		return checkExpr(stmt.getExpr());
	}

	@Override
	public Boolean visit(SimpleQuestion stmt) {
		/**
		 * if the syntax is correct then
		 * the type will also be correct
		 */
		return true;
	}
	
	@Override
	public Boolean visit(Label stmt) {
		return checkExpr(stmt.getExpr());
	}
	
	@Override
	public Boolean visit(Stmts stmts) {
		return checkSataments(stmts);
	}

	public Env getEnv() {
		return env;
	}

	public List<QlTypeError> getMessages() {
		return messages;
	}
	
	private boolean checkExpr(Expr expr) {
		return ExprTypeChecker.Check(expr, env, messages);		
	}

	private boolean checkTypes(Ident ident, Type assignedType) {
		Type identType = ident.typeOf(env);		
		if(identType.isError()) {
			addToErrorList(ident, ((QlTypeError)identType).getMessage());
			return false;
		}
		
		if(!identType.isCompatibleTo(assignedType)) {
			addToErrorList(ident, "can not convert type " +
					assignedType.getClass() + " to type " + identType.getClass());
			return false;
		}		
		return true;
	}
	
	private boolean checkIfBody(Stmts stmts) {
		return stmts.accept(this);
	}
	
	private Boolean checkSataments(Stmts stmts) {
		int countErrors = 0;
		for(Stmt statement: stmts) {
			if(!statement.accept(this))
				countErrors++;
		}
		return countErrors == 0;
	}	
	
	private void addToErrorList(ASTNode ast, String message) {
		messages.add(new QlTypeError("Type error at node " + 
			ast.getClass() + ". Message: " + message));		
	}	
}
