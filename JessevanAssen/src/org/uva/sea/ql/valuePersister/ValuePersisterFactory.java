package org.uva.sea.ql.valuePersister;

import org.uva.sea.ql.TimeSourceFactory;
import org.uva.sea.ql.valuePersister.persisters.filePersister.FilePersister;
import org.uva.sea.ql.valuePersister.persisters.filePersister.TimestampNamingConvention;
import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

public class ValuePersisterFactory {

    public static ValuePersister createValuePersister() {
        return new FilePersister(
                new CsvValueSerializer(),
                new TimestampNamingConvention(TimeSourceFactory.createTimeSource())
        );
    }

}
