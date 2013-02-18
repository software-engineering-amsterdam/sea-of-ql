package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

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
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();	
		errors.addAll(super.checkType(env));
		
		for(Statement statement : elseBody){
			errors.addAll(statement.checkType(env));
		}		
		
		return errors;
	}
	
	@Override
	public String toString(int indentation) {
		String returnString = super.toString(indentation); 
		returnString += getIndentation(indentation);
		returnString += "else";
		returnString += newLine;
		
		for(Statement statement : elseBody){
			returnString += statement.toString(indentation + 1);
		}
		return returnString; 
	}
	
	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) {
		ArrayList<BaseComponent> components = new ArrayList<BaseComponent>();
		
		components.addAll(super.getUIComponents(env, form));
		
		for(Statement statement : elseBody){
			components.addAll(statement.getUIComponents(env, form));
		}
		
		return components;
	}
	
	@Override
	public boolean eval(Env env) {
		evalIf(env);
		setVisible(!((BoolVal)condition.eval(env)).getValue());
		
		boolean retVal = true; 
		for(Statement statement : elseBody){
			retVal = statement.eval(env) && retVal; 
		}
		return retVal; 
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
	
}
