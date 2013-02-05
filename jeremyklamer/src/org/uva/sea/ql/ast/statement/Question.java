package org.uva.sea.ql.ast.statement;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;

import ui.UIComponent;

public class Question extends Statement {	
	
	private final Ident name; 
	private final String sentence; 
	private final Type returnType; 
	
	//TODO Kan twee keer in tabel voorkomen als zelfde type. 
	
	public Question(Ident ident, String sentence , Type returnType){
		this.name = ident; 
		this.sentence = sentence;
		this.returnType = returnType;
	}

	public Ident getName() {
		return name;
	}
	
	public String getSentence() {
		return sentence;
	}

	public Type getReturnType() {
		return returnType;
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Message> errors = new ArrayList<Message>();
		
		if(!(typeEnv.containsKey(name))){
			typeEnv.put(name, returnType);
		}
		else if(!(typeEnv.get(name).getClass().equals(returnType.getClass()))){
			errors.add(new Error(name.getName() + " is already defined as type : " + getSimpleName(returnType)));
		}
		
		return errors;
	}
	
	@Override
	public void printSelf(int indentation){
		printIndentation(indentation);
		System.out.println(getSimpleName(this) + ", Ident : " + name.getName() + " : " + sentence + " return value : " + getSimpleName(returnType));
	}

	@Override
	public List<UIComponent> getUIComponents() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		
		components.add(new UIComponent(new Label(sentence), null));
		components.add(returnType.getAnswerComp());
		
		return components;
		
	}
	
}
