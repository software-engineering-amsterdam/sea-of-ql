package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

    @Override
    public Value evaluate()
    {
        // TODO lookup di variable map
        return null;
    }

}
