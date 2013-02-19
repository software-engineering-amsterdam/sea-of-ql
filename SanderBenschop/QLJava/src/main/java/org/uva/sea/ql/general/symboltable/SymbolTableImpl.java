package org.uva.sea.ql.general.symboltable;

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
    public void addIdentifier(Ident identifier, Type type) {
        identifierTypeMap.put(identifier, type);
    }

    @Override
    public Type getIdentifier(Ident identifier) {
        return identifierTypeMap.get(identifier);
    }

    @Override
    public boolean containsIdentifier(Ident identifier) {
        return identifierTypeMap.containsKey(identifier);
    }

    @Override
    public void clear() {
        identifierTypeMap.clear();
    }
}
