package org.uva.sea.ql.parser.test;

import org.junit.Test;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.dependencies.IVariableResolver;
import org.uva.sea.ql.dependencies.VariableResolver;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.runtime.Variable;

public class TestDependencies {

	@Test
	public void testDependencyFinder() {
		IParser parser = new JACCParser();
		Form form = (Form)parser.parse("form myForm {\n" +
						"\"Q1\" a : bool\n" +
						"\"Q2\" b : bool\n" +
						"\"Q3\" c = a && b\n" +
						"\"Q4\" d : money\n" +
						"\"Q5\" e : money\n" +
						"\"Q6\" f = e > d && c\n" +
						"}");
		IVariableResolver variableResolver = new VariableResolver();
		Iterable<Variable> variables = variableResolver.getVariables(form);
		
		int q = 3;
	}
}
