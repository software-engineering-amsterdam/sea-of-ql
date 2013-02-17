package org.uva.sea.ql.run;

import java.io.IOException;

import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.generation.html.HTMLDocument;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.Validator;

 final class GenerationRunner {
    private GenerationRunner() {

    }

    public static void main(String[] args) {
        try {

            final IParse parser = new ANTLRParser();
            final Form e = parser.parseDefaultFile();
            new Validator().validate(e);
            final Form f = (Form) e;
            final VisitorDocumentBuilder visitor = new VisitorDocumentBuilder(
                    new HTMLDocument());
            f.accept(visitor);
            final String output = (String) visitor.getOutput();
            IOHelper.write(IOHelper.OUT_PATH + f.getName() + ".html", output);
            System.out.println(output);

        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
        } catch (ParseError ex) {
            System.out.println("ParseError: " + ex.getMessage());
        } catch (AstValidationError ex) {
            System.out.println("AST Validation Error: " + ex.getMessage());
        } catch (VisitorException ex) {
            System.out.println("Visitor Error: " + ex.getMessage());
        }

    }
}
