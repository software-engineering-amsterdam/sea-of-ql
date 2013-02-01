package org.uva.sea.ql.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.SymbolTable;
import org.uva.sea.ql.ast.traversal.TypeChecker;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.ast.types.literals.*;

// Test the type checking functionality
public class TestTypeChecker extends TestBase {
	// Filenames for forms to parse and typecheck
	private static final String RESOURCE_FORM_VALID = "form_valid.ql";
	private static final String RESOURCE_FORM_INVALID = "form_invalid.ql";

	private final TypeChecker typeChecker = new TypeChecker();
	private Form validForm;
	private Form invalidForm;

	// A parsed form is a precondition for this test
	@Before
	public void beforeTypeCheckingTests() throws IOException,
			RecognitionException {
		validForm = parseFormFromResource(RESOURCE_FORM_VALID);
		invalidForm = parseFormFromResource(RESOURCE_FORM_INVALID);
	}

	@Test
	public void testValidForm() throws RecognitionException, IOException {
		validForm.accept(typeChecker);
		assertEquals(0, typeChecker.getErrorLog().getLength());
	}

	@Test
	public void testInvalidForm() throws RecognitionException, IOException {
		invalidForm.accept(typeChecker);
		assertEquals(12, typeChecker.getErrorLog().getLength());
	}
	
	@Test
	public void testTypeOf() {
		final SymbolTable table = mock(SymbolTable.class);

		assertEquals(BoolType.class, new BoolLiteral(false).typeOf(table).getClass());
		assertEquals(IntType.class, new IntLiteral(0).typeOf(table).getClass());
		assertEquals(MoneyType.class, new MoneyLiteral("0.0").typeOf(table).getClass());
		assertEquals(StringType.class, new StringLiteral("wqeqwe").typeOf(table).getClass());
		assertNull(mock(Ident.class).typeOf(table));
		
		assertEquals(BoolType.class, new GT(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new LEq(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new Eq(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new LT(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new GT(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new And(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new Or(mock(Expression.class), mock(Expression.class))
									.typeOf(table).getClass());
		assertEquals(BoolType.class, new Not(mock(Expression.class)).typeOf(table).getClass());
		
		assertEquals(NumericType.class, new Add(mock(Expression.class), mock(Expression.class))
										.typeOf(table).getClass());
		assertEquals(NumericType.class, new Sub(mock(Expression.class), mock(Expression.class))
										.typeOf(table).getClass());
		assertEquals(NumericType.class, new Div(mock(Expression.class), mock(Expression.class))
										.typeOf(table).getClass());
		assertEquals(NumericType.class, new Mul(mock(Expression.class), mock(Expression.class))
										.typeOf(table).getClass());
		assertEquals(NumericType.class, new Neg(mock(Expression.class)).typeOf(table).getClass());
		assertEquals(NumericType.class, new Pos(mock(Expression.class)).typeOf(table).getClass());
	}

	@Test
	public void testTypeCompatibility() {
		final BoolType boolType = new BoolType();
		assertTrue(boolType.isCompatibleToBool());
		assertFalse(boolType.isCompatibleToInt());
		assertFalse(boolType.isCompatibleToMoney());
		assertFalse(boolType.isCompatibleToNumeric());
		assertFalse(boolType.isCompatibleToString());
		
		final IntType intType = new IntType();
		assertFalse(intType.isCompatibleToBool());
		assertTrue(intType.isCompatibleToInt());
		assertTrue(intType.isCompatibleToMoney());
		assertFalse(intType.isCompatibleToString());
		assertTrue(intType.isCompatibleToNumeric());
		
		final MoneyType moneyType = new MoneyType();
		assertFalse(moneyType.isCompatibleToBool());
		assertTrue(moneyType.isCompatibleToInt());
		assertTrue(moneyType.isCompatibleToMoney());
		assertFalse(moneyType.isCompatibleToString());
		assertTrue(moneyType.isCompatibleToNumeric());		
		
		final StringType stringType = new StringType();
		assertFalse(stringType.isCompatibleToBool());
		assertFalse(stringType.isCompatibleToInt());
		assertFalse(stringType.isCompatibleToMoney());
		assertTrue(stringType.isCompatibleToString());
		assertFalse(stringType.isCompatibleToNumeric());
	}
	
	@After
	public void printErrorLog() {
		typeChecker.getErrorLog().write(System.err);
		typeChecker.getEventLog().write(System.out);
	}
}
