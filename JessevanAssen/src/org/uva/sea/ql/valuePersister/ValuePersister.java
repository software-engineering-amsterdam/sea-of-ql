package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Value;

import java.util.Map;

public interface ValuePersister {

    public void persist(Map<Ident, Value> values);

}
