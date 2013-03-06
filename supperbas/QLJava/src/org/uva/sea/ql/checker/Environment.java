package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Message;


public class Environment {
	private final Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	private final List<Message> messages = new ArrayList<Message>();

	public Environment() {
	}

	public Map<Ident, Type> getTypeEnv() {
		return typeEnv;
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	public void addError(String err) {
		this.messages.add(new Message(err));
	}

	public void printErrors() {
		System.out.println("There was an error during parsing:");
		for (Message i : this.getMessages())
			System.out.println("-" + i.getMessage());
	}
}
