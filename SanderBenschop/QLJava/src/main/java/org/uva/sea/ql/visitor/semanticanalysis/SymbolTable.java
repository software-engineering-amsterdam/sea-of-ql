package org.uva.sea.ql.visitor.semanticanalysis;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private final Map<Ident, Type> identifierTypeMap;

    public SymbolTable() {
        this.identifierTypeMap = new HashMap<Ident, Type>();
    }

    public void setReducableToType(Ident astNode, Type type) {
        identifierTypeMap.put(astNode, type);
    }

    public Type getReduceableType(Ident astNode) {
        return identifierTypeMap.get(astNode);
    }

    public boolean containsReductionFor(Ident node) {
        return identifierTypeMap.containsKey(node);
    }

    public void clear() {
        identifierTypeMap.clear();
    }
}
