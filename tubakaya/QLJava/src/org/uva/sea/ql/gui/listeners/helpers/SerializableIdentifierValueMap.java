package org.uva.sea.ql.gui.listeners.helpers;

import java.io.Serializable;
import java.util.Map;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.QLValue;

public class SerializableIdentifierValueMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<Identifier, QLValue> identifierValueMap;

	public SerializableIdentifierValueMap(
			Map<Identifier, QLValue> identifierValueMap) {
		this.identifierValueMap = identifierValueMap;
	}

	public Map<Identifier, QLValue> getIdentifierValueMap() {
		return this.identifierValueMap;
	}

}
