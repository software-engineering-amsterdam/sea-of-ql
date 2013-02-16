package org.uva.sea.ql.validation;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public final class ValidationRunner {

    private ValidationRunner() {

    }

    public static void main(String args[]) throws Exception {
        final Validator v = new Validator();
        try {
            final IParse parser = new ANTLRParser();
            final Form e = parser.parseDefaultFile();
            v.validate(e);
        } catch (VisitorException ex) {
            ex.printStackTrace();
        }
        System.out.println("validation finished");
    }
}
