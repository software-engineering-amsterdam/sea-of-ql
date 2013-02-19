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
import org.uva.sea.ql.ui.observing.ComputedObserver;
import org.uva.sea.ql.ui.observing.QuestionObservable;


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
	public List<BaseComponent> getUIComponents(Env env, Form form) {
		List<BaseComponent> components = new ArrayList<BaseComponent>();
		
		QuestionComponent uiComponent = new QuestionComponent(sentence, true, returnType.getAnswerComponent());

		QuestionObservable observable = new QuestionObservable(this, env, uiComponent);
		env.registerObservable(name, observable);
		
		uiComponent.getAnswerField().addFocusListener(observable);
		env.registerObserver(new ComputedObserver(this, uiComponent.getAnswerField(), env));
				
		components.add(uiComponent);
		return components; 
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
