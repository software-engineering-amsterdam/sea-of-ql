package org.uva.sea.ql.gui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.types.Type;
import org.uva.sea.ql.ast.value.Value;

public class Environment {
	private Map<Ident,Question> idQuestionMap;
	
	public Environment () {
		idQuestionMap = new HashMap<Ident, Question>();
	}
	
	public Environment (Map<Ident,Question> m) {
		idQuestionMap = m;
	}

	public boolean containsKey(Ident id) {
		return idQuestionMap.containsKey(id);
	}
	
	public Value<?> getValueByID(Ident id) {
		return get(id).getValue();
	}
	
	public Type getTypeByID(Ident id) {
		return get(id).getType();
	}

	public Question get(Ident id) {
		return idQuestionMap.get(id);
	}

	public Collection<Question> values() {
		return idQuestionMap.values();
	}

	public void put(Ident id, Question q) {
		idQuestionMap.put(id, q);
	}

}
