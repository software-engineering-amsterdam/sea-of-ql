package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.SemanticException;
import org.uva.sea.ql.parser.SemanticVisitor;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

@RunWith(Parameterized.class)
public class TestSemanticConsistency {

	private IParse parser;
	
	private final String sourceFile;

	public TestSemanticConsistency(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	@Parameters
	public static Collection<String[]> data() {
		String[][] data = new String[][] { 
					{ "semanticVarUndef.ql"}, {"semanticCyclicDep.ql"}, 
					{"semanticExpressionType1.ql"}, {"semanticExpressionType2.ql"}, {"semanticExpressionType3.ql"}, {"semanticExpressionType4.ql"}, /*{"semanticExpressionType5.ql"}*/ };
		return Arrays.asList(data);
	}

	@Before
	public void setup() {
		parser = new JaccQLParser();
	}

	@Test(/*expected = SemanticException.class*/)
	public void test() throws ParseError, IOException {
		final String qlText = readResource(sourceFile);
		Form form = parser.parseForm(qlText);
		assertNotNull(form);

		SemanticVisitor visitor = new SemanticVisitor();
		form.accept(visitor);
	}

	private String readResource(final String resourceName) throws IOException {
		return IOUtils.toString(this.getClass().getResourceAsStream(
				"resources\\" + resourceName));
	}

}
