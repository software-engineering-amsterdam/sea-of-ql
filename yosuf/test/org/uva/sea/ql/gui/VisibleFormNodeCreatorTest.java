package org.uva.sea.ql.gui;

import static org.junit.Assert.fail;
import javafx.scene.Node;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.CompoundStatement;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.IfStatement;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.lead.Model;

public class VisibleFormNodeCreatorTest {

	private Model model;
	VisibleFormNodeCreator creator;

	@Before
	public void setUp() {
		model = new Model();
		creator = new VisibleFormNodeCreator(model);
	}

	@Test
	public void testVisitIfStatement() {

		Computed computed = new Computed(new IntegerType(), new Identifier(
				"cash"), new IntegerValue(900));
		BooleanValue exp = new BooleanValue(true);

		IfStatement ifStm = new IfStatement(exp,
				new CompoundStatement(computed));

		Node node = creator.visit(ifStm);

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
