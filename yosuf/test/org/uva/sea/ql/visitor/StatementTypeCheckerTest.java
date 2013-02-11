package org.uva.sea.ql.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Form;
import org.uva.sea.ql.ast.stm.IfElseStatement;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.stm.Question;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public class StatementTypeCheckerTest {

	private ExpressionTypeChecker expressionChecker;
	private StatementTypeChecker statementChecker;
	private Computed computed;
	private CompoundStatement compound;

	@Before
	public void setUp() {
		expressionChecker = new ExpressionTypeChecker();
		statementChecker = new StatementTypeChecker(expressionChecker);

		computed = new Computed(new IntegerType(), new Identifier("1"),
				new IntegerValue(5));

		compound = new CompoundStatement(computed);
	}

	@Test(expected = IllegalStateException.class)
	public void testConstructor() {
		new StatementTypeChecker(null);
	}

	@Test
	public void testVisitValidForm() {

		statementChecker.visit(new Form(new Identifier("2"), compound));
		assertErrors(0);
	}

	@Test
	public void testVisitInValidForm() {
		Computed errorneous = new Computed(new BooleanType(), new Identifier(
				"3"), new IntegerValue(5));
		CompoundStatement body = new CompoundStatement(errorneous);

		statementChecker.visit(new Form(new Identifier("4"), body));
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

		statementChecker.visit(new Computed(new BooleanType(), new Identifier(
				"5"), new IntegerValue(5)));
		assertErrors(1);
	}

	@Test
	public void testVisitIfStatement() {

		statementChecker.visit(new IfStatement(new BooleanValue(false),
				compound));
		assertErrors(0);

		statementChecker.visit(new IfStatement(new IntegerValue(0),
				new CompoundStatement(new Computed(new IntegerType(),
						new Identifier("9"), new IntegerValue(7)))));
		assertErrors(1);
	}

	@Test
	public void testVisitIfElseStatement() {
		statementChecker.visit(new IfElseStatement(new BooleanValue(true),
				compound, new CompoundStatement(new Computed(new IntegerType(),
						new Identifier("9"), new IntegerValue(7)))));
		assertErrors(0);

		statementChecker.visit(new IfElseStatement(new StringValue("val"),
				compound, new CompoundStatement(new Computed(new IntegerType(),
						new Identifier("20"), new IntegerValue(7)))));
		assertErrors(2);
	}

	@Test
	public void testVisitQuestion() {

		statementChecker.visit(new Question(new IntegerType(), new Identifier(
				"6"), new StringValue("What is your name?")));

		statementChecker.visit(new Question(new BooleanType(), new Identifier(
				"7"), new StringValue("What is your name?")));

		statementChecker.visit(new Question(new StringType(), new Identifier(
				"8"), new StringValue("What is your name?")));

		assertErrors(0);

	}

	private void assertErrors(final int numberOfErrors) {
		assertEquals(numberOfErrors, statementChecker.getAllTypeErrors().size());
	}
}
