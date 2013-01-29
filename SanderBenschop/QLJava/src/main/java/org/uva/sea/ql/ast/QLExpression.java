package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.typechecking.SymbolTable;

public interface QLExpression extends ASTNode {

    Type getType(SymbolTable symbolTable);
}
