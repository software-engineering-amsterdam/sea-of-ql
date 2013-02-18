package org.uva.sea.ql.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegeneration.bootstrap.BootstrapGenerator;
import org.uva.sea.ql.ast.traversal.codegeneration.bootstrap.base.IWebGenerator;


public class TestBootstrapGenerator extends TestBase {
	private static final String RESOURCE_FORM_VALID = "forms/form_valid.ql";
	private static final String OUTPUT_FILE = "generated.html";
	private static final String OUTPUT_FOLDER = "./temp/";
	private IWebGenerator generator = new BootstrapGenerator("codegeneration/templates", "127.0.0.1:8080");
	
	private Form form;
	private File outputDirectory;

	@Before
	public void beforeTest() throws Exception {
		outputDirectory = new File(OUTPUT_FOLDER);
		form = parseFormFromResource(RESOURCE_FORM_VALID);
		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}

		if (!outputDirectory.exists()) {
			throw new Exception("Necessary output directory does not exist and is not created");
		}
	}

	@Test
	public void testGenerateCode() throws Exception {
		generator.generateFrontEnd(form, OUTPUT_FOLDER, OUTPUT_FILE);
		
		File outputFile = new File(outputDirectory, OUTPUT_FILE);
		assertNotNull(outputFile);
		assertTrue(outputFile.exists());
		List<String> outputContents = IOUtils.readLines(new FileInputStream(outputFile));
		assertNotNull(outputContents);
		assertFalse(outputContents.size() == 0);
		
		// Check whether the form name is traceable
		assertTrue(containsSubstring(outputContents, form.getName()));
	}
	
	@After
	public void afterTest() {
		if (outputDirectory.exists()) {
			outputDirectory.delete();
		}
	}
	
	private boolean containsSubstring(List<String> lines, String substring) {
		for (String line : lines) {
			// Find the sub string
			if (line.toLowerCase().contains(substring.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}
}
