package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public class StatementTypeCheckerTest {

	private ExpressionTypeChecker expressionChecker;
	private StatementTypeChecker statementChecker;
	private Identifier identifier;
	private Computed computed;
	private CompoundStatement compound;

	@Before
	public void setUp() {
		expressionChecker = new ExpressionTypeChecker();
		statementChecker = new StatementTypeChecker(expressionChecker);

		identifier = new Identifier("someId");
		computed = new Computed(new IntegerType(), identifier,
				new IntegerValue(5));

		compound = new CompoundStatement(computed);
	}

	@Test(expected = IllegalStateException.class)
	public void testConstructor() {
		new StatementTypeChecker(null);
	}

	@Test
	public void testVisitValidForm() {

		statementChecker.visit(new Form(identifier, compound));
		assertErrors(0);
	}

	@Test
	public void testVisitInValidForm() {
		Computed errorneous = new Computed(new BooleanType(), identifier,
				new IntegerValue(5));
		CompoundStatement body = new CompoundStatement(errorneous);

		statementChecker.visit(new Form(identifier, body));
		assertErrors(1);
	}

	@Test
	public void testVisitCompoundStatement() {
		statementChecker.visit(compound);
		assertErrors(0);
	}

	@Test
	public void testVisitComputed() {
		statementChecker.visit(computed);
		assertErrors(0);

		statementChecker.visit(new Computed(new BooleanType(), identifier,
				new IntegerValue(5)));
		assertErrors(1);
	}

	@Test
	public void testVisitIfStatement() {

		statementChecker.visit(new IfStatement(new BooleanValue(false),
				compound));
		assertErrors(0);

		statementChecker.visit(new IfStatement(new IntegerValue(0), compound));
		assertErrors(1);

	}

	@Test
	public void testVisitIfElseStatement() {
		statementChecker.visit(new IfElseStatement(new BooleanValue(true),
				compound, compound));
		assertErrors(0);

		statementChecker.visit(new IfElseStatement(new StringValue("val"),
				compound, compound));
		assertErrors(1);
	}

	@Test
	public void testVisitQuestion() {

		statementChecker.visit(new Question(new IntegerType(), identifier,
				new StringValue("What is your name?")));

		statementChecker.visit(new Question(new BooleanType(), identifier,
				new StringValue("What is your name?")));

		statementChecker.visit(new Question(new StringType(), identifier,
				new StringValue("What is your name?")));

		assertErrors(0);

	}

	private void assertErrors(final int numberOfErrors) {
		assertEquals(numberOfErrors, statementChecker.getTypeErrors().size());

	}
}
