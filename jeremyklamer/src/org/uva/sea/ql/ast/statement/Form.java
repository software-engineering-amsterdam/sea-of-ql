package org.uva.sea.ql.ast.statement;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

import ui.UIComponent;

public class Form extends Statement{
	
	private final List<Statement> body; 
	private final Ident name; 
	
	public Form(Ident name, List<Statement> body) {
		this.name = name;
		this.body = body;
	}

	public Ident getName() {
		return name;
	}

	public List<Statement> getBody() {
		return body;
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Message> errors = new ArrayList<Message>();
		
		for(Statement statement : body){
			errors.addAll(statement.checkType(typeEnv));
		}
		
		return errors;
	}
	
	@Override
	public void printSelf(int indentation){
		printIndentation(indentation);
		System.out.println(getSimpleName(this) + ", Ident : " + this.name.getName());
		
		for(Statement statement : body){
			statement.printSelf(indentation + 1);
		}
	}

	@Override
	public List<UIComponent> getUIComponents() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		
		components.add(new UIComponent(new Label(this.name.getName()), "wrap"));
		
		for(Statement statement : this.body){
			components.addAll(statement.getUIComponents());
		}
		
		return components;
	}
	
}
