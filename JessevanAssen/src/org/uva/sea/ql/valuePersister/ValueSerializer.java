package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Value;

import java.util.Map;

public interface ValueSerializer {
    public String serialize(Map<Identifier, Value> values);
    public <T> T accept(ValueSerializerVisitor<T> visitor);
}
