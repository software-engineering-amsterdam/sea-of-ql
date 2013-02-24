package org.uva.sea.ql.parser.test.semantic;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.StrType;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.parser.test.AbstractTest;
import org.uva.sea.ql.parser.typechecker.Environment;

public abstract class TypeTest extends AbstractTest {
	private Environment environment;
	
	protected abstract boolean typeCheck(String src) throws ParseError;
	
	public TypeTest() {
		environment = new Environment();
		
		environment.setType(new Ident("intA", null), new IntType(null));
		environment.setType(new Ident("boolB", null), new BoolType(null));
		environment.setType(new Ident("strC", null), new StrType(null));
	}
	
	protected Environment getEnvironment() {
		return environment;
	}
	
}
