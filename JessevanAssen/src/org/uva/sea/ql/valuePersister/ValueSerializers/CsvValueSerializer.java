package org.uva.sea.ql.valuePersister.valueSerializers;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.valuePersister.ValueSerializer;
import org.uva.sea.ql.valuePersister.ValueSerializerVisitor;

import java.util.Map;

public class CsvValueSerializer implements ValueSerializer {
    @Override
    public String serialize(Map<Ident, Value> values) {
        final String headers = "\"Identifier\",\"Value\"";

        StringBuilder csvBuilder = new StringBuilder(headers).append(System.lineSeparator());
        for(Map.Entry<Ident, Value> entry : values.entrySet())
            csvBuilder
                    .append("\"").append(entry.getKey()).append("\",")
                    .append("\"").append(entry.getValue()).append("\"")
                    .append(System.lineSeparator());

        return csvBuilder.toString();
    }

    @Override
    public <T> T accept(ValueSerializerVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
