package org.uva.sea.ql.ast.traversal.codegen;

import java.io.File;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegen.base.WebGenerationException;

public interface IWebGenerator {
	void generateFrontend(Form form, File outputDirectory, String outputFilename) throws WebGenerationException;
}
