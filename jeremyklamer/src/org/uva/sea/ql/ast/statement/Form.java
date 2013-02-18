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
	public String toString(int indentation) {
		String returnString = getIndentation(indentation);
		returnString += getSimpleName(this) + ", Ident : " + this.name.getName();
		returnString += newLine;
		for(Statement statement : body){
			returnString += statement.toString(indentation + 1);
		}
		return returnString;
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

	//Form never gets set to visbile or invisble, only other statements. 
	@Override
	public void setVisible(boolean visible) {
	}
	
}
