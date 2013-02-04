package org.uva.sea.ql.valuePersister.persisters.filePersister;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.valuePersister.ValuePersister;
import org.uva.sea.ql.valuePersister.ValuePersisterException;
import org.uva.sea.ql.valuePersister.ValueSerializer;
import org.uva.sea.ql.valuePersister.ValueSerializerVisitor;
import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

import java.io.*;
import java.util.Map;

public class FilePersister implements ValuePersister {

    private static class ExtensionVisitor implements ValueSerializerVisitor<String> {
        @Override public String visit(CsvValueSerializer valueSerializer) { return ".csv"; }
    }


    private final ValueSerializer serializer;
    private final NamingConvention namingConvention;

    public FilePersister(ValueSerializer serializer, NamingConvention namingConvention) {
        this.serializer = serializer;
        this.namingConvention = namingConvention;
    }

    @Override
    public void persist(Map<Ident, Value> values) {
        try{
            File file = createFile();
            serializeValuesToFile(values, file);
        } catch(IOException ex) {
            throw new ValuePersisterException("An error ocurred while persisting to a file.", ex);
        }
    }

    private void serializeValuesToFile(Map<Ident, Value> values, File file) throws IOException {
        FileOutputStream stream = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(stream);
        writer.write(serializer.serialize(values));
        writer.close();
        stream.close();
    }

    private File createFile() throws IOException {
        File file = new File(namingConvention.getName() + serializer.accept(new ExtensionVisitor()));
        if(!file.exists())
            file.createNewFile();
        return file;
    }
}
