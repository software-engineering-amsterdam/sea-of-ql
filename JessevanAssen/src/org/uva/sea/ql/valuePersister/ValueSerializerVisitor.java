package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

public interface ValueSerializerVisitor<T> {
    T visit(CsvValueSerializer valueSerializer);
}
