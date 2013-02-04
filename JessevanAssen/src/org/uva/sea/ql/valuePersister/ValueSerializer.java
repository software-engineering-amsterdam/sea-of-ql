package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Value;

import java.util.Map;

public interface ValueSerializer {
    public String serialize(Map<Ident, Value> values);
    public <T> T accept(ValueSerializerVisitor<T> visitor);
}
