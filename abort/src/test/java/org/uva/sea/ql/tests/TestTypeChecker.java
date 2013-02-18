package org.uva.sea.ql.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.*;

import org.antlr.runtime.RecognitionException;
import org.junit.*;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.typechecking.*;
import org.uva.sea.ql.ast.types.datatypes.*;

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
	public void beforeTypeCheckingTests() throws IOException, RecognitionException {
		validForm = parseFormFromResource(RESOURCE_FORM_VALID);
		invalidForm = parseFormFromResource(RESOURCE_FORM_INVALID);
	}

	@Test
	public void testValidForm() throws RecognitionException, IOException {
		validForm.accept(typeChecker);
		assertEquals(0, typeChecker.getErrorCount());
	}

	@Test
	public void testInvalidForm() throws RecognitionException, IOException {
		invalidForm.accept(typeChecker);
		assertEquals(12, typeChecker.getErrorCount());
	}

	@Test
	public void testTypeOf() {
		mock(SymbolTable.class);
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
		typeChecker.writeErrorLog(System.err);
		typeChecker.writeEventLog(System.out);
	}
}
