package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.traversal.logging.Message;
import org.uva.sea.ql.ast.traversal.logging.TypeErrorLog;
import org.uva.sea.ql.ast.traversal.logging.TypeEventLog;
import org.uva.sea.ql.ast.types.literals.BoolLiteral;
import org.uva.sea.ql.ast.types.literals.Ident;
import org.uva.sea.ql.ast.types.literals.IntLiteral;

public class TestLogs extends TestBase {
	@Test
	public void testEventLog() {
		final TypeEventLog eventLog = new TypeEventLog();
		assertEquals(0, eventLog.getLength());
		eventLog.add(new Message(mock(Form.class), "Successful event"));
		assertTrue(eventLog.toString().contains("Successful event"));
		eventLog.addCorrectSemantics(mock(Form.class));
		assertEquals(2, eventLog.getLength());
		assertTrue(eventLog.toString().length() > 0);
		eventLog.write(System.out);
	}
	
	@Test
	public void testErrorLog() {
		final TypeErrorLog errorLog = new TypeErrorLog();
		assertEquals(0, errorLog.getLength());
		errorLog.add(new Message(mock(Form.class), "Error example"));
		assertTrue(errorLog.toString().contains("Error example"));
		assertEquals(1, errorLog.getLength());
		errorLog.addBothSidesAreDifferentTypes(mock(BinaryOperator.class));
		errorLog.addEmptyFlow(mock(Node.class));
		errorLog.addExpectedDifferentType(mock(Node.class), IntLiteral.class);
		
		final List<Class<? extends Node>> typeList = new ArrayList<Class<? extends Node>>(); 
		typeList.add(BoolLiteral.class);
		typeList.add(IntLiteral.class);
		errorLog.addExpectedDifferentTypes(mock(Node.class), typeList);
		errorLog.addInvalidReference(mock(Form.class), "reference");
		errorLog.addEmptyFlow(mock(Node.class));
		errorLog.addExpectedDifferentType(mock(Node.class), IntLiteral.class);
		errorLog.addLabelRedeclaration(mock(Node.class), new Ident("identName"));
		errorLog.addTypeIsNotBoolean(HandSide.LEFT, mock(BinaryOperator.class));
		errorLog.addTypeIsNotIntegerOrMoney(HandSide.BOTH, mock(BinaryOperator.class));
		assertEquals(11, errorLog.getLength());
		assertTrue(errorLog.toString().length() > 0);
		errorLog.write(System.err);		
	}
}
