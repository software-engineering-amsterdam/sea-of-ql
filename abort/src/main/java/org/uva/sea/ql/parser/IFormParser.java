package org.uva.sea.ql.parser;

import java.io.*;

import org.uva.sea.ql.ast.form.Form;

public interface IFormParser {
	Form parseForm(File inputFile) throws ParsingException;
}
