package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.message.Message;

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
	
}
