package org.uva.sea.ql.codegeneration;

import org.uva.sea.ql.ast.statement.Conditional;

public final class ConditionalIdentifierGenerator {

    private static final String IDENTIFIER_PREFIX = "conditional";

    protected static String generateIdentifier(Conditional conditional) {
        return IDENTIFIER_PREFIX + conditional.hashCode();
    }
}
