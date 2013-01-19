package org.uva.sea.ql.parser.visitor.typechecking;

import java.util.HashMap;
import java.util.Map;

public class ReductionTable {

    private Map<Integer, Class<?>> typeReductionMap;

    public ReductionTable() {
        this.typeReductionMap = new HashMap<Integer, Class<?>>();
    }

    public void setReducableToType(Object object, Class<?> type) {
        typeReductionMap.put(object.hashCode(), type);
    }

    public boolean isReducableToType(Object object, Class<?> type) {
        return getReduceableType(object) == type;
    }

    public Class<?> getReduceableType(Object object) {
        return typeReductionMap.get(object.hashCode());
    }
}
