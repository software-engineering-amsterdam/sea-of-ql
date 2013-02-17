package org.uva.sea.ql.visitor.codegeneration;

import org.uva.sea.ql.ast.Form;

public interface CodeGenerator {

    String generateQLCode(Form form);
}
