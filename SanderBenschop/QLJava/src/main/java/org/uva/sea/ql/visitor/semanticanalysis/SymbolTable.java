package org.uva.sea.ql.visitor.semanticanalysis;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;

public interface SymbolTable {

    void setReducableToType(Ident identifier, Type type);

    Type getReduceableType(Ident identifier);

    boolean containsReductionFor(Ident identifier);

    void clear();
}
