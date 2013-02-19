package org.uva.sea.ql.codegeneration;

public class IdentifierSequenceGenerator {

    private final String identifierPrefix;

    private int nextIdentifierNumber;

    public IdentifierSequenceGenerator(String identifierPrefix) {
        this.nextIdentifierNumber = 0;
        this.identifierPrefix = identifierPrefix;
    }

    public String getNextIdentifier() {
        String identifier = identifierPrefix + nextIdentifierNumber;
        nextIdentifierNumber++;
        return identifier;
    }
}
