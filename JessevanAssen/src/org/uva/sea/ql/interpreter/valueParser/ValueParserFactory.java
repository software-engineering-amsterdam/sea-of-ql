package org.uva.sea.ql.interpreter.valueParser;

import org.uva.sea.ql.ast.type.*;

public class ValueParserFactory implements TypeVisitor<ValueParser, Void> {
    private static class ValueParserFactoryException extends RuntimeException {
        public ValueParserFactoryException(String message) {
            super(message);
        }
    }

    private ValueParserFactory() { }

    public static ValueParser createValueParser(Type type) {
        return type.accept(new ValueParserFactory(), null);
    }

    @Override
    public ValueParser visit(Bool type, Void param) {
        return new BoolValueParser();
    }

    @Override
    public ValueParser visit(Int type, Void param) {
        return new IntValueParser();
    }

    @Override
    public ValueParser visit(Str type, Void param) {
        return new StrValueParser();
    }

    @Override
    public ValueParser visit(Unknown type, Void param) {
        throw new ValueParserFactoryException("There should be no need to parse Unknown values.");
    }
}
