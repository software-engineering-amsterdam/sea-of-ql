package khosrow.uva.sea.ql.visitor.eval;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.stmt.Stmt;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlDeclarationError;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.check.StmtTypeChecker;

public class FormEvaluator {	
	private final Env env;	
	private final List<QlDeclarationError> declarationErrors;
	private final List<QlTypeError> typeErrors;
	private final List<String> errorList;	

	private FormEvaluator(Env env, List<String> errorList) {			
		this.env = env;		
		this.typeErrors = new ArrayList<QlTypeError>();
		this.declarationErrors = new ArrayList<QlDeclarationError>();
		this.errorList = errorList;
	}
	
	
	public static void evaluate(Stmt stmt, Env env, List<String> ErrorList) {
		FormEvaluator evaluator = new FormEvaluator(env, ErrorList);
		try{
			evaluator.evaluate(stmt);
		}
		catch(Exception ex){
			throw new RuntimeException("The source code contains " + ex.getMessage());
		}						
	}
	
	
	private void evaluate(Stmt stmt) {
		evaluateDecls(stmt);
		evaluateTypes(stmt);
	}

	private void evaluateDecls(Stmt stmt) {
		boolean declSucceeded = DeclEvaluator.Evaluate(stmt, env, declarationErrors);
		if(!declSucceeded) {
			addDeclErrorsToErrorList();
			throw new RuntimeException("declaration errors");
		}
	}
	
	private void evaluateTypes(Stmt stmt) {
		boolean typeSucceeded = StmtTypeChecker.Check(stmt, env, typeErrors);
		if(!typeSucceeded) {
			addTypeErrorsToErrorList();
			throw new RuntimeException("type errors");
		}
	}
	
	private void addDeclErrorsToErrorList() {
		for(QlDeclarationError error:declarationErrors)
			errorList.add(error.getMessage());		
	}
	
	private void addTypeErrorsToErrorList() {
		for(QlTypeError error:typeErrors)
			errorList.add(error.getMessage());		
	}		
	
	public Env getEnv() {
		return env;
	}

}
