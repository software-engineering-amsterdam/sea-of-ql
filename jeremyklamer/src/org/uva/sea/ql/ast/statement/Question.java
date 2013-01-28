package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

public class Question extends Statement {	
	
	private final Ident name; 
	private final String sentence; 
	private final Type returnType; 
	
	//TODO Kan twee keer in tavbel voorkomen als zelfde type. 
	
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
		
		if(!(typeEnv.containsKey(getName()))){
			typeEnv.put(this.name, this.returnType);
		}
		
		return errors;
	}
	
}
