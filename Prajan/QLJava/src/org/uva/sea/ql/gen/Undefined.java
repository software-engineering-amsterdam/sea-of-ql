package org.uva.sea.ql.gen;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.visitor.Value;

public class Undefined {

	public static final Value UNDEF = new Ident("Unsupported");

}
