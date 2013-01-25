package org.uva.sea.ql.interpreter.valueParser;

import org.uva.sea.ql.ast.type.*;

import java.lang.Void;

public class ValueParserFactory implements TypeVisitor<ValueParser, Void> {
    private static class ValueParserFactoryException extends RuntimeException {
        public ValueParserFactoryException(String message) {
            super(message);
        }
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

    @Override
    public ValueParser visit(org.uva.sea.ql.ast.type.Void type, Void param) {
        throw new ValueParserFactoryException("There should be no need to parse Void values.");
    }
}
