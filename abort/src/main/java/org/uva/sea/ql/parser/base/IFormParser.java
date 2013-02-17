package org.uva.sea.ql.parser.base;

import java.io.*;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.ParsingException;

public interface IFormParser {
	Form parseForm(File inputFile) throws ParsingException;
}
