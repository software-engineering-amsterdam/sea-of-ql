package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

import ui.UIComponent;

public class IfThenElse extends If{
	
	private final List<Statement> elseBody;
	
	public IfThenElse(Expr condition, List<Statement> ifBody, List<Statement> elseBody){
		super(condition,ifBody);
		this.elseBody = elseBody;
	}
	
	public List<Statement> getElseBody() {
		return elseBody;
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		ArrayList<Message> errors = new ArrayList<Message>();
		
		errors.addAll(super.checkType(typeEnv));
		
		for(Statement statement : elseBody){
			errors.addAll(statement.checkType(typeEnv));
		}		
		
		return errors;
	}
	
	@Override
	public void printSelf(int indentation){
		super.printSelf(indentation);
		printIndentation(indentation);
		System.out.println("Else");
		
		for(Statement statement : elseBody){
			statement.printSelf(indentation + 1);
		}
	}
	
	@Override
	public List<UIComponent> getUIComponents() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		
		components.addAll(super.getUIComponents());
		
		for(Statement statement : elseBody){
			components.addAll(statement.getUIComponents());
		}
		
		return components;
	}
}
