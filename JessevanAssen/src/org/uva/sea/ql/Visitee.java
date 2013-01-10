package org.uva.sea.ql;

public interface Visitee {
	public <ReturnType, ParameterType> ReturnType accept(Visitor<ReturnType, ParameterType> visitor, ParameterType param);
}
