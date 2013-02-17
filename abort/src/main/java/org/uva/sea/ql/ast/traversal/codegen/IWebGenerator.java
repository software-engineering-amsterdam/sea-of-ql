package org.uva.sea.ql.ast.traversal.codegen;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegen.base.WebGenerationException;

public interface IWebGenerator {
	void generateFrontend(Form form, String outputDirectory, String outputFilename) throws WebGenerationException;
}
