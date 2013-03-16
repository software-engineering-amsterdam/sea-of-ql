package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

@SuppressWarnings("unchecked")
public class TestForms {

	private IParse parser;

	@Before
	public void setup() {
		parser = new JaccQLParser();
	}

	private String readResource(final String resourceName) throws IOException {
		return IOUtils.toString(this.getClass().getResourceAsStream("resources\\" + resourceName));
	}
	
	private static void assertAST(Statement astNode, Class<? extends ASTNode>... expectedASTClasses) {
		final TestVisitor tv = new TestVisitor();
		astNode.accept(tv);
		tv.assertAST(expectedASTClasses);
	}

	@Test
	public void testSimpleQlForm1() throws ParseError, IOException {
		final String qlText = readResource("simpleQlForm1.ql");
		final Form form = parser.parseForm(qlText);
		assertNotNull(form);

		assertAST(form, Form.class, CompoundStatement.class, Question.class, IfStatement.class, Identifier.class, CompoundStatement.class, Question.class);
	}

	@Test
	public void testSimpleQlForm2() throws ParseError, IOException {
		final String qlText = readResource("simpleQlForm2.ql");
		Form form = parser.parseForm(qlText);
		assertNotNull(form);
		
		assertAST(form, Form.class, CompoundStatement.class, Question.class, IfStatement.class, Identifier.class, CompoundStatement.class,
				Question.class, Question.class, IfStatement.class, GT.class, Sub.class, Identifier.class, Identifier.class, IntLiteral.class, CompoundStatement.class, Question.class);
	}
	
}
