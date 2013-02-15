package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.base.SyntaxPosition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.operators.binary.Add;
import org.uva.sea.ql.ast.operators.binary.And;
import org.uva.sea.ql.ast.operators.binary.Div;
import org.uva.sea.ql.ast.operators.binary.Eq;
import org.uva.sea.ql.ast.operators.binary.GT;
import org.uva.sea.ql.ast.operators.binary.LEq;
import org.uva.sea.ql.ast.operators.binary.LT;
import org.uva.sea.ql.ast.operators.binary.Mul;
import org.uva.sea.ql.ast.operators.binary.Or;
import org.uva.sea.ql.ast.operators.binary.Sub;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.traversal.codegen.BootstrapGenerator;
import org.uva.sea.ql.ast.traversal.typechecking.SymbolTable;
import org.uva.sea.ql.ast.traversal.typechecking.TypeChecker;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.IntType;
import org.uva.sea.ql.ast.types.datatypes.MoneyType;
import org.uva.sea.ql.ast.types.datatypes.NumericType;
import org.uva.sea.ql.ast.types.datatypes.StringType;
import org.uva.sea.ql.ast.types.literals.BoolLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.MoneyLiteral;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

// Test the type checking functionality
public class TestTypeChecker extends TestBase {
	// Filenames for forms to parse and type check
	private static final String RESOURCE_FORM_VALID = "forms/form_valid.ql";
	private static final String RESOURCE_FORM_INVALID = "forms/form_invalid.ql";

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
/*
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
									.typeOf(table).getClass(), mock(SyntaxPosition.class));
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
		
		*/
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
	public void printErrorLog() throws FileNotFoundException {
		typeChecker.getErrorLog().write(System.err);
		typeChecker.getEventLog().write(System.out);
	}
	
	@Test
	public void testTemplate() {
		// System.out.println(new BootstrapGenerator().generateFrontend(validForm));
		System.out.println(new BootstrapGenerator().generateFrontend(validForm, "resources/codegeneration/generated.html"));
	}
}
