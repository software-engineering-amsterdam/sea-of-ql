package org.uva.sea.ql.parser.test;

import org.junit.Before;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.conditional.Conditional;
import org.uva.sea.ql.ast.nodetypes.formelements.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.exception.ParseError;

public abstract class TestParser {

	private IParse parser;
	
	@Before
	public void prepareTest() {
		
		this.parser = new ANTLRParser();
	}

	protected Form parseForm(String source) throws ParseError {
		
		return (Form) parser.parse(source);
	}
	
	protected QLStatement parseStatement(String source) throws ParseError {
		
		String template = "form FormName { %s }";
		Form form = parseForm(String.format(template, source));
		return form.getStatements().get(0);
	}

	protected QLExpression parseExpression(String source) throws ParseError {
		
		String template = "if(%s){}";
		Conditional statement = (Conditional) parseStatement(String.format(template, source));
		return statement.getCondition();
	}
}
