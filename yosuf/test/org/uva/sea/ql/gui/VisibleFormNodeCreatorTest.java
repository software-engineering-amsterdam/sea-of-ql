package org.uva.sea.ql.gui;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.lead.Model;

public class VisibleFormNodeCreatorTest {

	private Model model;
	QLNodeVisitor creator;

	@Before
	public void setUp() {
		model = new Model();
		creator = new QLNodeVisitor(model);
	}

	@Test(expected = IllegalStateException.class)
	public void testVisitIfStatementExpressionNotRegistred() {

		Computed computed = new Computed(new IntegerType(), new Identifier(
				"cash"), new NumericValue(900));

		IfStatement ifStm = new IfStatement(new BooleanValue(true),
				new CompoundStatement(computed));

		creator.visit(ifStm);
	}

	@Test
	public void testVisibleFormNodeCreator() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitCompoundStatement() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitComputed() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitIfElseStatement() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisitQuestion() {
		fail("Not yet implemented");
	}

}
