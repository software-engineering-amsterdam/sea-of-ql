package org.uva.sea.ql.codegeneration.sequencegenerator;

public class ConditionalIdentifierSequenceGenerator implements IdentifierSequenceGenerator {

    private static final String IDENTIFIER_PREFIX = "conditional";

    private int nextIdentifierNumber;

    public ConditionalIdentifierSequenceGenerator() {
        this.nextIdentifierNumber = 0;
    }

    @Override
    public String getNextIdentifier() {
        String identifier = IDENTIFIER_PREFIX + nextIdentifierNumber;
        nextIdentifierNumber++;
        return identifier;
    }
}
