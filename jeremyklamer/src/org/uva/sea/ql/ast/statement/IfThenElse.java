package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;


public class IfThenElse extends If{
	
	private final List<Statement> elseBody;
	
	
	public IfThenElse(Expr condition, List<Statement> ifBody, List<Statement> elseBody){
		super(condition,ifBody);
		this.elseBody = elseBody;
	}
	
	public List<Statement> getElseBody() {
		return elseBody;
	}

	@Override
	public void checkType(List<Message> errors, Env env) {
		super.checkType(errors, env);
		for(Statement statement : elseBody){
			statement.checkType(errors, env);
		}		
	}
	
	@Override
	public void getUIComponents(List<BaseComponent> components, Env env, Form form) {		
		super.getUIComponents(components, env, form);
		
		for(Statement statement : elseBody){
			statement.getUIComponents(components, env, form);
		}
	}
	
	@Override
	public void eval(Env env) {
		evalIf(env);
		setVisible(!((BoolVal)condition.eval(env)).getValue());
		//boolean retVal = true; 
		for(Statement statement : elseBody){
			//retVal = statement.eval(env) && retVal;
			statement.eval(env);
		}
		//return retVal; 
	}
	
	@Override
	public void initTypes(Env env) {
		super.initTypes(env);
		for(Statement statement : elseBody){
			statement.initTypes(env);
		}
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(!visible);
		for(Statement statement : elseBody){
			statement.setVisible(visible);
		}
	}
	
	
	@Override
	public String genFormFeedBack(Env env, int indentation) {
		StringBuilder feedBack = new StringBuilder();
		feedBack.append(super.genFormFeedBack(env, indentation));
		feedBack.append(getIndentation(indentation));
		feedBack.append("Else"); 
		feedBack.append(newLine);
		for(Statement statement : elseBody) {
			feedBack.append(statement.genFormFeedBack(env, indentation + 1));
		}
		return feedBack.toString();
	}
}
