package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.*;

public class Ding {
	
	protected Ident name;
	protected Str question;
	protected Type type;

	public Ding(Ident id, Str q, Type t) {
		name = id;
		question = q;
		type = t;
	}
}
