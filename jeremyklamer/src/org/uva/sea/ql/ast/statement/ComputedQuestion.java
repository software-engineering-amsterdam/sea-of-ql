package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.ui.components.BaseComponent;
import org.uva.sea.ql.ui.components.QuestionComponent;


public class ComputedQuestion extends Question{
	
	private final Expr computation;
	
	public ComputedQuestion(Ident ident, String sentence , Type returnType, Expr computation){
		super(ident,sentence,returnType);
		this.computation = computation;
	}

	public Expr getComputation() {
		return computation;
	}

	@Override
	public void printSelf(int indentation){
		printIndentation(indentation);
		System.out.println(getSimpleName(this) + ", Ident : " + name.getName() + " : " + sentence + " return value : " + getSimpleName(getReturnType()));
	}
	
	@Override
	public List<BaseComponent> getUIComponents(Env env, Form form) {
		ArrayList<BaseComponent> components = new ArrayList<BaseComponent>();

		uiComponent = new QuestionComponent(sentence, true, returnType.getAnswerComponent(env, form, name));
		components.add(uiComponent);
		return components;
	}
	
	@Override
	public boolean eval(Env env) {
		if(!(computation.checkType(env).size() > 0)){
			uiComponent.updateValue(computation.eval(env));
		}	
		return false;		
	}
}
