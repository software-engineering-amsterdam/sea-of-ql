package org.uva.sea.ql.tests.valuePersister.valueSerializers;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Bool;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.ast.expression.value.Str;
import org.uva.sea.ql.ast.expression.value.Value;
import org.uva.sea.ql.valuePersister.valueSerializers.CsvValueSerializer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class CsvValueSerializerTests {

    CsvValueSerializer serializer = new CsvValueSerializer();

    private static final String HEADERS = String.format("\"Identifier\",\"Value\"%s", System.lineSeparator());

    @Test
    public void emptyMapAsParameter_onlyHeaders() {
        Map<Identifier, Value> values = new HashMap<Identifier, Value>(0);
        String result = serializer.serialize(values);
        assertEquals(HEADERS, result);
    }

    @Test
    public void filledMapAsParameter_serializedValues() {
        // A LinkedHashMap is used instead of a regular HashMap, because a LinkedHashMap retains order.
        // This is necessary for the test, because else the values within the map are shuffled.
        Map<Identifier, Value> values = new LinkedHashMap<Identifier, Value>(3);
        values.put(new Identifier("a"), new Bool(true));
        values.put(new Identifier("b"), new Int(1));
        values.put(new Identifier("c"), new Str("a"));

        String result = serializer.serialize(values);

        assertEquals(
                new StringBuilder(HEADERS)
                        .append("\"a\",\"true\"").append(System.lineSeparator())
                        .append("\"b\",\"1\"").append(System.lineSeparator())
                        .append("\"c\",\"a\"").append(System.lineSeparator())
                        .toString(),
                result
        );
    }

}
