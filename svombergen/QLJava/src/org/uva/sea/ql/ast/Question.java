package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.*;

public class Question {
	
	protected Ident name;
	protected Str question;
	protected Type type;

	public Question(Ident id, Str q, Type t) {
		name = id;
		question = q;
		type = t;
	}
}
