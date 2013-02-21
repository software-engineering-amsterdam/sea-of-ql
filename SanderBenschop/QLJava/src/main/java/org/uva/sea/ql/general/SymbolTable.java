package org.uva.sea.ql.general;

import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.type.Type;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private final Map<Ident, Type> identifierTypeMap;

    public SymbolTable() {
        this.identifierTypeMap = new HashMap<Ident, Type>();
    }

    public void addIdentifier(Ident identifier, Type type) {
        identifierTypeMap.put(identifier, type);
    }

    public Type getIdentifier(Ident identifier) {
        return identifierTypeMap.get(identifier);
    }

    public boolean containsIdentifier(Ident identifier) {
        return identifierTypeMap.containsKey(identifier);
    }

    public void clear() {
        identifierTypeMap.clear();
    }
}
