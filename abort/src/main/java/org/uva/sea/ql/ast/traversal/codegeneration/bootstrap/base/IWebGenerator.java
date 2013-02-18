package org.uva.sea.ql.ast.traversal.codegeneration.bootstrap.base;

import org.uva.sea.ql.ast.form.Form;

/**
 * Represents a code generator for a web front-end.
 * 
 * @author J. Dijkstra
 */
public interface IWebGenerator {
	/**
	 * Generates a web front-end based on a form.
	 *  
	 * @param form form to generate front-end from
	 * @param outputDirectory directory to output files
	 * @param outputFilename filename to output
	 * @throws WebGenerationException
	 */
	void generateFrontEnd(Form form, String outputDirectory, String outputFilename) throws WebGenerationException;
}
