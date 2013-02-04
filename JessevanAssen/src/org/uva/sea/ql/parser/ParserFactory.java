package org.uva.sea.ql.parser;

import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class ParserFactory {
    public static Parser createParser() {
        return new ANTLRParser();
    }
}
