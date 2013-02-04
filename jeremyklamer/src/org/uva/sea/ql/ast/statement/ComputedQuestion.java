package org.uva.sea.ql.ast.statement;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;

import ui.UIComponent;

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
		System.out.println(getSimpleName(this) + ", Ident : " + this.getName().getName() + " : " + getSentence() + " return value : " + getSimpleName(getReturnType()));
	}
	
	@Override
	public List<UIComponent> getUIComponents() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		
		components.add(new UIComponent(new Label(getSentence()), null));
		//TODO change to give actual answer
		components.add(new UIComponent(new Label("ANSWER"), "wrap"));
		
		return components;
	}
}
