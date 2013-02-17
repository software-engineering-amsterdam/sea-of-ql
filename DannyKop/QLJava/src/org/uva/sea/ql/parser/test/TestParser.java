package org.uva.sea.ql.parser.test;

import org.junit.Before;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public abstract class TestParser {
	
	private ANTLRParser parser;
	
	@Before
	public void prepareTest(){
		this.parser = new ANTLRParser();
	}
	
	protected FormElement parseFormElement(String str) throws ParseError{
		String tmp = "form tester {" + str + "}";
		Form f = parseForm(tmp);
		return f.getElements().get(0);
	}
	
	protected Form parseForm(String str) throws ParseError {
		return (Form) parser.parse(str);
	}

}
