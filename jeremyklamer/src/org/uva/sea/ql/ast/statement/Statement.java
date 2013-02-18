package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;


public abstract class Statement implements ASTNode{

	protected String newLine = "\n"; //TODO System.getProperty("line.separator");
	
	public abstract List<Message> checkType (Env env);
	
	public abstract List<BaseComponent> getUIComponents(Env env, Form form);
	
	protected static String getSimpleName(Object e) { 
		return e.getClass().getSimpleName();
	}
	
	public abstract String toString(int indentation);
	
	//TODO Better Function for this?? 
	protected String getIndentation(int indentation){
		String returnString = "";
		for(int i = 0; i < indentation; i++){
			returnString += "  ";
		}	
		return returnString; 
	}
	
	public abstract boolean eval(Env env);
	
	public abstract void initTypes(Env env);
	
	public abstract void setVisible(boolean visible);
	
}
