package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.dependencies.IVariableResolver;
import org.uva.sea.ql.dependencies.VariableResolver;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;

public class TestDependencies {

	@Test
	public void testDependencyFinder() {
		final IParser parser = new JACCParser();
		final Form form = (Form) parser.parse("form myForm {\n"
				+ "\"Q1\" a : bool\n" + "\"Q2\" b : bool\n"
				+ "\"Q3\" c = a && b\n" + "\"Q4\" d : money\n"
				+ "\"Q5\" e : money\n" + "\"Q6\" f = e > d && c\n" + "}",
				"test");
		final IVariableResolver variableResolver = new VariableResolver();
		variableResolver.getRuntimeValues(form);
	}
}
