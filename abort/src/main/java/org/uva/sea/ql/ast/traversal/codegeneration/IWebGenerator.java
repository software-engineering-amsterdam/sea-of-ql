package org.uva.sea.ql.ast.traversal.codegeneration;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.traversal.codegeneration.base.WebGenerationException;

/**
 * Represents a code generator for a web front-end.
 * 
 * @author J. Dijkstra
 */
public interface IWebGenerator {
	void generateFrontEnd(Form form, String outputDirectory, String outputFilename) throws WebGenerationException;
}
