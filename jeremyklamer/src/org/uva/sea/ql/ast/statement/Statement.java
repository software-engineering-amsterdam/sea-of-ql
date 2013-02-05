package org.uva.sea.ql.ast.statement;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

import ui.UIComponent;

public abstract class Statement implements ASTNode{

	public abstract List<Message> checkType (Map<Ident, Type> typeEnv);
	
	public abstract List<UIComponent> getUIComponents();
	
	protected static String getSimpleName(Object e) { 
		return e.getClass().getSimpleName();
	}
	
	public abstract void printSelf(int indentation);
	
	public void printIndentation(int indentation){
		for(int i = 0; i < indentation; i++){
			System.out.print("  ");
		}	
	}
}
