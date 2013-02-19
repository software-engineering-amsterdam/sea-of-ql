package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.ui.components.BaseComponent;


public abstract class Statement implements ASTNode{

	protected String newLine = System.getProperty("line.separator");
	protected String errorStartSign = "ERROR:  ";
	
	public abstract List<Message> checkType(Env env);
	public abstract List<Message> getErrorsMessages(Env env);
	public abstract List<BaseComponent> getUIComponents(Env env, Form form);
	public abstract boolean eval(Env env);
	public abstract void initTypes(Env env);
	public abstract void setVisible(boolean visible);
	public abstract String genFormFeedBack(Env env, int indentation);
	
	protected String getIndentation(int indentation){
		StringBuilder indent = new StringBuilder();
		for(int i = 0; i < indentation; i++){
			indent.append("  ");
		}	
		return indent.toString(); 
	}
	
	//TODO Maybe non static and this.getSimpleName?? 
	protected static String getSimpleName(Object e) { 
		return e.getClass().getSimpleName();
	}
	
}
