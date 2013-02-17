package org.uva.sea.ql.visitor.semanticanalysis;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private final Map<Ident, Type> typeReductionMap;

    public SymbolTable() {
        this.typeReductionMap = new HashMap<Ident, Type>();
    }

    public void setReducableToType(Ident astNode, Type type) {
        typeReductionMap.put(astNode, type);
    }

    public Type getReduceableType(Ident astNode) {
        return typeReductionMap.get(astNode);
    }

    public boolean containsReductionFor(Ident node) {
        return typeReductionMap.containsKey(node);
    }

    public void clear() {
        typeReductionMap.clear();
    }
}
