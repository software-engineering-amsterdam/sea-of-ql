package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.components.QuestionComponent;
import org.uva.sea.ql.ui.observing.QuestionObservable;


public class Question extends Statement {	
	
	protected final Ident name; 
	protected final String sentence; 
	protected final Type returnType; 
	
	public Question(Ident ident, String sentence , Type returnType) {
		this.name = ident; 
		this.sentence = sentence;
		this.returnType = returnType;
	}

	public Type getReturnType() {
		return returnType;
	}
	
	public Ident getName() {
		return name; 
	}
	
	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) { 	
		List<BaseComponent> components = new ArrayList<BaseComponent>();
		QuestionComponent uiComponent = new QuestionComponent(sentence, false, returnType.getAnswerComponent());
		QuestionObservable observable = new QuestionObservable(this, env, uiComponent);
		env.registerObservable(name, observable);
		uiComponent.getAnswerField().addActionListener(observable);
		components.add(uiComponent);
		return components;
	}
	
	@Override
	public void checkType(List<Message> errors, Env env) {
		getErrorsMessages(errors, env);
	}
	
	@Override
	public void getErrorsMessages(List<Message> errors, Env env) {
		if(env.containsType(name)) {
			if(!(env.getType(name).getClass().equals(returnType.getClass()))) {
				errors.add(new Error(name.getName() + " is already defined as type : " + getSimpleName(env.getType(name))));
			}
		}
	}	

	@Override
	public void initTypes(Env env) {
		if(!(env.containsType(name))){
			env.putType(name, returnType);
			env.putValue(name, returnType.getDefaultValue());
		}
	}

	@Override
	public String genFormFeedBack(Env env, int indentation) {
		StringBuilder feedBack = new StringBuilder(getIndentation(indentation));
		feedBack.append(name.getName() + " : " + sentence + " return type : " + getSimpleName(returnType)); 
		feedBack.append(newLine);
		ArrayList<Message> errors = new ArrayList<Message>();
		getErrorsMessages(errors , env);
		for(Message message : errors) {
			feedBack.append(errorStartSign);
			feedBack.append(message.getMessage());
			feedBack.append(newLine);
		}
		return feedBack.toString();
	}
	
}
