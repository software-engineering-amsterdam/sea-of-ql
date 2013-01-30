package org.uva.sea.ql.tests.valuePersister.destinations.fileDestination;

import org.junit.Test;
import org.uva.sea.ql.valuePersister.ValueSerializerVisitor;
import org.uva.sea.ql.valuePersister.persisters.filePersister.FilePersister;
import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

import java.lang.reflect.Constructor;

import static junit.framework.Assert.assertEquals;

public class ExtensionVisitorTests {

    private final ValueSerializerVisitor<String> extensionVisistor = createExtensionVisitor();

    private ValueSerializerVisitor<String> createExtensionVisitor() {
        try {
            Constructor<?> constructor = FilePersister.class
                    .getDeclaredClasses()[1] // 0 is the class itself, 1 is the inner class
                    .getDeclaredConstructor();
            constructor.setAccessible(true);
            return (ValueSerializerVisitor<String>) constructor.newInstance();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void passedCsvValueSerializer_returnsCsvExtension() {
        assertEquals(
            ".csv",
            new CsvValueSerializer().accept(extensionVisistor)
        );
    }

}
