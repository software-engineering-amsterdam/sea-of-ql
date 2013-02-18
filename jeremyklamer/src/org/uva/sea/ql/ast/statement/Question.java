package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.components.QuestionComponent;


public class Question extends Statement {	
	
	protected final Ident name; 
	protected final String sentence; 
	protected final Type returnType; 
	protected QuestionComponent uiComponent; 
	
	protected BaseComponent label; 
	protected BaseComponent answerField; 
	
	public Question(Ident ident, String sentence , Type returnType) {
		this.name = ident; 
		this.sentence = sentence;
		this.returnType = returnType;
	}

	public Type getReturnType() {
		return returnType;
	}
	
	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) { 
		ArrayList<BaseComponent> components = new ArrayList<BaseComponent>();
	
		uiComponent = new QuestionComponent(sentence, false, returnType.getAnswerComponent(env, form, name));
		components.add(uiComponent);
		
		return components;
	}
	
	@Override
	public List<Message> checkType(Env env) {
		ArrayList<Message> errors = new ArrayList<Message>();
		
		if(env.containsType(name)) {
			if(!(env.getType(name).getClass().equals(returnType.getClass()))) {
				errors.add(new Error(name.getName() + " is already defined as type : " + getSimpleName(returnType)));
			}
		}
		return errors;
	}

	@Override
	public boolean eval(Env env) {
		return env.containsValue(name);
	}

	@Override
	public void initTypes(Env env) {
		if(!(env.containsType(name))){
			env.putType(name, returnType);
			env.putValue(name, returnType.getDefaultValue());
		}
	}

	@Override
	public void setVisible(boolean visible) {
		uiComponent.setVisible(visible);
	}
	
	@Override
	public String toString(int indentation) {
		String returnString = getIndentation(indentation);
		
		returnString += getSimpleName(this) + ", Ident : " + name.getName() + " : " + sentence + " return value : " + getSimpleName(returnType);
		returnString += newLine;
		
		return returnString;
	}

}
