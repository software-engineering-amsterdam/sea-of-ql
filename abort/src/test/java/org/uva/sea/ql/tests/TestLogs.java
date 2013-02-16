package org.uva.sea.ql.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.uva.sea.ql.ast.base.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.traversal.logging.*;
import org.uva.sea.ql.ast.types.Ident;

// Test log functionality used for typechecking
public class TestLogs extends TestBase {
	@Test
	public void testEventLog() {
		final TypeEventLog eventLog = new TypeEventLog();
		assertEquals(0, eventLog.getLength());

		// Create a mocked form that contains a syntax position
		final Form form = createNodeMock(Form.class);

		eventLog.add(new TypeMessage(form, "Successful event"));
		assertTrue(eventLog.toString().contains("Successful event"));
		eventLog.addCorrectSemantics(form);

		// Should have two messages by now
		assertEquals(2, eventLog.getLength());
		assertTrue(eventLog.toString().length() > 0);
		eventLog.write(System.out);

		assertEquals("", new TypeEventLog().toString());
	}

	@Test
	public void testErrorLog() {
		final TypeErrorLog errorLog = new TypeErrorLog();
		assertEquals(0, errorLog.getLength());

		// Test for a form error
		errorLog.add(new TypeMessage(createNodeMock(Form.class), "Error example"));
		assertTrue(errorLog.toString().contains("Error example"));
		assertEquals(1, errorLog.getLength());

		errorLog.addBothSidesAreDifferentTypes(createNodeMock(BinaryOperator.class));
		errorLog.addInvalidReference(createNodeMock(Expression.class));
		errorLog.addIdentRedeclaration(createNodeMock(Statement.class), createNodeMock(Ident.class));
		errorLog.addTypeIsNotBoolean(HandSide.LEFT, createNodeMock(BinaryOperator.class));
		errorLog.addTypeIsNotIntegerOrMoney(HandSide.BOTH, createNodeMock(BinaryOperator.class));

		// Should have errors
		assertEquals(6, errorLog.getLength());
		assertTrue(errorLog.toString().length() > 0);

		errorLog.write(System.err);

		assertEquals("", new TypeErrorLog().toString());
	}

	// Create mocks that contain a syntax position
	private <T extends Node> T createNodeMock(final Class<T> typeToMock) {
		final T mockInstance = mock(typeToMock);
		when(mockInstance.getSyntaxPosition()).thenReturn(generateSyntaxPosition());
		return mockInstance;
	}
}
