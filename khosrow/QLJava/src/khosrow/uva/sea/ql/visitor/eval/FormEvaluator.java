package khosrow.uva.sea.ql.visitor.eval;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlDeclarationError;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;
import khosrow.uva.sea.ql.visitor.check.StmtTypeChecker;

public class FormEvaluator {
	//private final Form form;
	private final Env env;	
	private final List<QlDeclarationError> declarationErrors;
	private final List<QlTypeError> typeErrors;
	private final List<String> ErrorList;
	private final IStmtVisitor<Void> interpreter;

	public FormEvaluator(Env env, IStmtVisitor<Void> interpreter) {			
		this.env = env;
		this.interpreter = interpreter;
		this.typeErrors = new ArrayList<QlTypeError>();
		this.declarationErrors = new ArrayList<QlDeclarationError>();
		this.ErrorList = new ArrayList<String>();
	}
	
	
	public void evaluate(Form form) {
		boolean declSucceeded = DeclEvaluator.Evaluate(form, env, declarationErrors);
		if(!declSucceeded) {
			addDeclErrorsToErrorList();
			throw new RuntimeException("The source code contains declaration errors.");
		}
		
		boolean typeSucceeded = StmtTypeChecker.Check(form.getStmts(), env, typeErrors);
		if(!typeSucceeded) {
			addTypeErrorsToErrorList();
			throw new RuntimeException("The source code contains type errors.");
		}
		
		interpreter.visit(form.getStmts());
	}


	private void addDeclErrorsToErrorList() {
		for(QlDeclarationError error:declarationErrors)
			ErrorList.add(error.getMessage());		
	}
	
	private void addTypeErrorsToErrorList() {
		for(QlTypeError error:typeErrors)
			ErrorList.add(error.getMessage());		
	}


	public List<String> getErrors() {
		return ErrorList;
	}	
	
	public Env getEnv() {
		return env;
	}

}
