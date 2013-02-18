package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.interpreter.BoolVal;
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
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		if(!(condition.typeOf(env).isCompatibleToBool())){
			errors.add(new Error("Condition does not resolve to Bool"));
		}
		
		errors.addAll(condition.checkType(env));		
		for(Statement statement : ifBody){
			errors.addAll(statement.checkType(env));
		}
		return errors;
	}
	
	@Override
	public void printSelf(int indentation){
		printIndentation(indentation);
		System.out.println(getSimpleName(this) + ", Condition : " + getSimpleName(this.condition));
		
		for(Statement statement : ifBody){
			statement.printSelf(indentation + 1);
		}
	}

	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) {
		ArrayList<BaseComponent> components = new ArrayList<BaseComponent>();
		
		for(Statement statement : ifBody){
			components.addAll(statement.getUIComponents(env, form));
		}
		
		return components;
	}

	@Override
	public boolean eval(Env env) {
		setVisible(((BoolVal)condition.eval(env)).getValue());
		return evalIf(env);
	}
	
	protected boolean evalIf(Env env){
		if(condition.checkType(env).size() > 0){
			return false;  
		}
		
		boolean retVal = true; 
		for(Statement statement : ifBody){
			retVal = statement.eval(env) && retVal; 
		}
		
		return retVal; 
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
	
}
