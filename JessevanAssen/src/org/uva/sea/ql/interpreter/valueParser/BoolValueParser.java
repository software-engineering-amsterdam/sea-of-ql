package org.uva.sea.ql.interpreter.valueParser;

import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Value;

public class BoolValueParser implements ValueParser {

    private static String TRUE_STRING = "true",
                          FALSE_STRING = "false";
    private static Bool DEFAULT = new Bool(false);

    @Override
    public Value parseValue(String value) {
        /**
         * This method doesn't use the Boolean.parseBoolean method, because it returns false if something can't be
         * parsed to a boolean instead of failing.
         */

        if(value.equals(TRUE_STRING))
            return new Bool(true);
        else if(value.equals(FALSE_STRING))
            return new Bool(false);
        else
            throw new ValueParserException(String.format("The value '%s' can't be parsed as a boolean.", value));
    }

    @Override
    public Value getDefault() {
        return DEFAULT;
    }
}
