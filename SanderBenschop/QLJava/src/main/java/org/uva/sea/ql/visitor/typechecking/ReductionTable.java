package org.uva.sea.ql.visitor.typechecking;

import org.uva.sea.ql.ast.ASTNode;

import java.util.HashMap;
import java.util.Map;

public class ReductionTable {

    private final Map<ASTNode, Class<?>> typeReductionMap;

    public ReductionTable() {
        this.typeReductionMap = new HashMap<ASTNode, Class<?>>();
    }

    public void setReducableToType(ASTNode astNode, Class<?> type) {
        typeReductionMap.put(astNode, type);
    }

    public Class<?> getReduceableType(ASTNode astNode) {
        return typeReductionMap.get(astNode);
    }

    public boolean containsReductionFor(ASTNode node) {
        return typeReductionMap.containsKey(node);
    }
}
