package org.uva.sea.ql.parsing;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parsing.error.SyntacticQLError;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Parser {

    Form parse(File file) throws IOException;

    Form parse(String src);

    boolean hasErrors();

    List<SyntacticQLError> getErrors();
}
