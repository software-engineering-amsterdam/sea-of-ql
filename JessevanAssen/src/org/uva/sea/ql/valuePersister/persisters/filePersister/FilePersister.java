package org.uva.sea.ql.valuePersister.persisters.filePersister;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.valuePersister.ValuePersister;
import org.uva.sea.ql.valuePersister.ValueSerializer;
import org.uva.sea.ql.valuePersister.ValueSerializerVisitor;
import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

import java.util.Map;

public class FilePersister implements ValuePersister {

    private static class ExtensionVisitor implements ValueSerializerVisitor<String> {
        @Override
        public String visit(CsvValueSerializer valueSerializer) {
            return ".csv";
        }
    }
    

    private final ValueSerializer serializer;
    private final NamingConvention namingConvention;

    public FilePersister(ValueSerializer serializer, NamingConvention namingConvention) {
        this.serializer = serializer;
        this.namingConvention = namingConvention;
    }

    @Override
    public void persist(Map<Ident, Value> values) {

    }

}
