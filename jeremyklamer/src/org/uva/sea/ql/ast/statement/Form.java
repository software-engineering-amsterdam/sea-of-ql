package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.components.LabelComponent;


public class Form extends Statement{
	
	private final List<Statement> body; 
	private final Ident name; 
	
	public Form(Ident name, List<Statement> body) {
		this.name = name;
		this.body = body;
	}
	
	public String getName(){
		return name.getName();
	}
	
	@Override
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		initTypes(env);
		for(Statement statement : body){
			errors.addAll(statement.checkType(env));
		}
		
		return errors;
	}

	@Override
	public List<Message> getErrorsMessages(Env env) {
		return null;
	}

	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) {
		ArrayList<BaseComponent> components = new ArrayList<BaseComponent>();
		
		components.add(new LabelComponent(this.name.getName(), "wrap"));
		
		for(Statement statement : this.body){
			components.addAll(statement.getUIComponents(env, form));
		}
		
		return components;
	}

	@Override
	public boolean eval(Env env) {
		boolean retVal = true;
		
		for(Statement statement : body){
			retVal = statement.eval(env) && retVal; 
		}
		return retVal;
	}

	@Override
	public void initTypes(Env env) {
		for(Statement statement : body){
			statement.initTypes(env);
		}
	}

	//A Form never gets set to visbile or invisble, only other statements. 
	@Override
	public void setVisible(boolean visible) {
	}
	
	@Override
	public String genFormFeedBack(Env env, int indentation) {
		StringBuilder feedBack = new StringBuilder();
		feedBack.append(name.getName()); 
		feedBack.append(newLine);
		for(Statement statement : body) {
			feedBack.append(statement.genFormFeedBack(env, indentation + 1));
		}
		return feedBack.toString();
	}
}
