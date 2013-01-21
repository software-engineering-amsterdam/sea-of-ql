package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.TypeChecker;

public class TestTypeChecker extends TestBase {
	private static final String RESOURCE_FORM_VALID = "form_valid.ql";
	private static final String RESOURCE_FORM_INVALID = "form_invalid.ql";		

	private final TypeChecker typeChecker = new TypeChecker();
	private Form validForm;
	private Form invalidForm;
	
	// A parsed form is a precondition for this test
	@Before
	public void beforeTypeCheckingTests() throws RecognitionException,IOException {
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
		assertEquals(31, typeChecker.getErrorLog().getLength());
	}
	
	@After
	public void printErrorLog() {
		typeChecker.getErrorLog().write(System.err);
		typeChecker.getEventLog().write(System.out);
	}
}
