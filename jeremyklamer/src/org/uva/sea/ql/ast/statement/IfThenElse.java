package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.observing.ConditionObserver;


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
	public List<BaseComponent> getUIComponents(Env env, Form form) {		
		List<BaseComponent> components = new ArrayList<BaseComponent>();
		List<BaseComponent> ifComponents = new ArrayList<BaseComponent>();
		List<BaseComponent> elseComponents = new ArrayList<BaseComponent>();
		
		for(Statement statement : ifBody){
			ifComponents.addAll(statement.getUIComponents(env, form));
		}
		
		for(Statement statement : elseBody){
			elseComponents.addAll(statement.getUIComponents(env, form));
		}
		env.registerObserver(new ConditionObserver(condition, elseComponents, ifComponents, env));
		components.addAll(ifComponents);
		components.addAll(elseComponents);
		
		return components;
	}

	@Override
	public void initTypes(Env env) {
		super.initTypes(env);
		for(Statement statement : elseBody){
			statement.initTypes(env);
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
