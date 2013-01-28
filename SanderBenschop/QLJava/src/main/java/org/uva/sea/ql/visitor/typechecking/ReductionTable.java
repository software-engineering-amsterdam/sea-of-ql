package org.uva.sea.ql.visitor.typechecking;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;

import java.util.HashMap;
import java.util.Map;

public class ReductionTable {

    private final Map<QLExpression, Class<?>> typeReductionMap;

    public ReductionTable() {
        this.typeReductionMap = new HashMap<QLExpression, Class<?>>();
    }

    public void setReducableToType(QLExpression astNode, Class<?> type) {
        typeReductionMap.put(astNode, type);
    }

    public Class<?> getReduceableType(QLExpression astNode) {
        return typeReductionMap.get(astNode);
    }

    public boolean containsReductionFor(QLExpression node) {
        return typeReductionMap.containsKey(node);
    }
}
