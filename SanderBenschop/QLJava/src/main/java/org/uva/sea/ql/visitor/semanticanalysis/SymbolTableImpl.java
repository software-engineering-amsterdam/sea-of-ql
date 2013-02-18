package org.uva.sea.ql.visitor.semanticanalysis;

import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.typeClasses.Type;

import java.util.HashMap;
import java.util.Map;

public class SymbolTableImpl implements SymbolTable {

    private final Map<Ident, Type> identifierTypeMap;

    public SymbolTableImpl() {
        this.identifierTypeMap = new HashMap<Ident, Type>();
    }

    @Override
    public void setReducableToType(Ident identifier, Type type) {
        identifierTypeMap.put(identifier, type);
    }

    @Override
    public Type getReduceableType(Ident identifier) {
        return identifierTypeMap.get(identifier);
    }

    @Override
    public boolean containsReductionFor(Ident identifier) {
        return identifierTypeMap.containsKey(identifier);
    }

    @Override
    public void clear() {
        identifierTypeMap.clear();
    }
}