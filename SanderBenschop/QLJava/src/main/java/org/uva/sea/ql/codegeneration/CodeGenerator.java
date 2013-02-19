package org.uva.sea.ql.codegeneration;

import org.uva.sea.ql.ast.Form;

public interface CodeGenerator {

    String generateQLCode(Form form);
}
