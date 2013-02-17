package org.uva.sea.ql.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.VisitorDocumentBuilder;
import org.uva.sea.ql.common.interfaces.ElementVisitor;
import org.uva.sea.ql.generation.html.HTMLDocument;

public class TestHtmlGenerator extends TestExpressions {
    public TestHtmlGenerator() {
        super();
    }

    @Test
    public final void testHtmlVisitor() {
        try {
            final Form f = parser.parseFile();
            final ElementVisitor html = new VisitorDocumentBuilder(
                    new HTMLDocument());
            html.visit(f);
        } catch (QLException ex) {
            Assert.fail("Exception occured during test: " + ex.getMessage());
        }
    }
}
