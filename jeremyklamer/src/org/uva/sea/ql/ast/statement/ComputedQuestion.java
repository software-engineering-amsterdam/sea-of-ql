package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.components.QuestionComponent;


public class ComputedQuestion extends Question {
	
	private final Expr computation;
	
	public ComputedQuestion(Ident ident, String sentence , Type returnType, Expr computation){
		super(ident,sentence,returnType);
		this.computation = computation;
	}

	public Expr getComputation() {
		return computation;
	}
	
	@Override
	public void getErrorsMessages(List<Message> errors, Env env) {
		super.getErrorsMessages(errors, env);
		computation.checkType(errors, env);
	}	
	
	@Override
	public void getUIComponents(List<BaseComponent> components, Env env, Form form) {
		uiComponent = new QuestionComponent(sentence, true, returnType.getAnswerComponent(env, form, name));
	//	env.registerObservable(this.name, uiComponent);
	//	env.registerObservers(this.computation, new Observer() {
//			
//			@Override
//			public void update(Observable o, Object arg) {
//				
//			}
//		})
		components.add(uiComponent);
	}
	
	@Override
	public void eval(Env env) {
		//This is not good, what does eval do!? 
		ArrayList<Message> errors = new ArrayList<Message>();
		computation.checkType(errors, env);
		if(!(errors.size() > 0)){
			uiComponent.updateValue(computation.eval(env));
		}	
		//return false;		
	}
	
	@Override
	public String genFormFeedBack(Env env, int indentation) {
		StringBuilder feedBack = new StringBuilder(getIndentation(indentation));
		feedBack.append(name.getName() + " : " + sentence + " return type : " + getSimpleName(returnType) + "(" + getSimpleName(computation) + ")"); 
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
