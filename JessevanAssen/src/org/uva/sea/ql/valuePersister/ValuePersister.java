package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Value;

import java.util.Map;

public interface ValuePersister {

    public void persist(Map<Identifier, Value> values);

}
