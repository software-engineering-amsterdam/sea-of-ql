package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;


public class If extends Statement{
	
	protected final Expr condition; 
	private final List<Statement> ifBody; 
	
	
	public If(Expr condition, List<Statement> ifBody){
		this.condition = condition;
		this.ifBody = ifBody;
	}

	@Override
	public void checkType(List<Message> errors, Env env) {
		getErrorsMessages(errors, env);
		condition.checkType(errors, env);		
		for(Statement statement : ifBody){
			statement.checkType(errors, env);
		}
	}
	

	@Override
	public void getErrorsMessages(List<Message> errors, Env env) {
		if(!(condition.typeOf(env).isCompatibleToBool())){
			errors.add(new Error("Condition does not resolve to Bool"));			
		}
		condition.checkType(errors, env);
	}
	
	@Override
	public void getUIComponents(List<BaseComponent> components, Env env, Form form) {
		for(Statement statement : ifBody){
			statement.getUIComponents(components, env, form);
		}
	}

	@Override
	public void eval(Env env) {
		//setVisible(((BoolVal)condition.eval(env)).getValue());
		//return evalIf(env);
		evalIf(env);
	}
	
	protected void evalIf(Env env){
		
		//Moet hier geen checktype! 
//		if(condition.checkType(env).size() > 0){
//			//return false;  
//		}
		
		//boolean retVal = true; 
		
		for(Statement statement : ifBody){
			//retVal = statement.eval(env) && retVal;
			statement.eval(env);
		}
		
		//return retVal; 
	}

	@Override
	public void initTypes(Env env) {
		for(Statement statement : ifBody){
			statement.initTypes(env);
		}
	}

	@Override
	public void setVisible(boolean visible) {
		for(Statement statement : ifBody){
			statement.setVisible(visible);
		}
	}
	

	@Override
	public String genFormFeedBack(Env env, int indentation) {
		StringBuilder feedBack = new StringBuilder(getIndentation(indentation));
		feedBack.append("If (" + getSimpleName(condition) + ")"); 
		feedBack.append(newLine);
		ArrayList<Message> errors = new ArrayList<Message>();
		getErrorsMessages(errors , env);
		for(Message message : errors) { 
			feedBack.append(errorStartSign);
			feedBack.append(message.getMessage());
			feedBack.append(newLine);
		}
		for(Statement statement : ifBody) {
			feedBack.append(statement.genFormFeedBack(env, indentation + 1));
		}
		return feedBack.toString();
	}
}
