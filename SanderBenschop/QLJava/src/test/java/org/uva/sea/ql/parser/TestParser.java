package org.uva.sea.ql.parser;

import junit.framework.Assert;
import org.junit.Before;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.ObjectLiteral;
import org.uva.sea.ql.ast.statement.Conditional;
import org.uva.sea.ql.parser.error.reporting.SyntacticErrorReporterImpl;
import org.uva.sea.ql.parser.exception.ParseException;

public abstract class TestParser {

    private Parser parser;

    @Before
    public void prepareTest() {
        this.parser = new ANTLRParser(new SyntacticErrorReporterImpl());
    }

    protected Form parseForm(String source) throws ParseException {
        return parser.parse(source);
    }

    protected QLStatement parseStatement(String source) throws ParseException {
        String template = "form FormName { %s }";
        Form form = parseForm(String.format(template, source));
        return form.getStatements().get(0);
    }

    protected QLExpression parseExpression(String source) throws ParseException {
        Conditional statement = wrapInConditionalAndParse(source);
        Assert.assertTrue("Attempted to parse non-expression to an expression.", statement.getCondition() instanceof QLExpression);
        return (QLExpression) statement.getCondition();
    }

    protected Ident parseIdent(String source) throws ParseException {
        Conditional statement = wrapInConditionalAndParse(source);
        Assert.assertTrue("Attempted to parse non-ident to an ident.", statement.getCondition() instanceof Ident);
        return (Ident) statement.getCondition();

    }

    protected ObjectLiteral<?> parsePrimary(String source) throws ParseException {
        String template = "if(%s){}";
        Conditional statement = (Conditional) parseStatement(String.format(template, source));
        Assert.assertTrue("Attempted to parse non-expression to an expression.", statement.getCondition() instanceof ObjectLiteral<?>);
        return (ObjectLiteral<?>) statement.getCondition();
    }

    private Conditional wrapInConditionalAndParse(String source) throws ParseException {
        String template = "if(%s){}";
        return (Conditional) parseStatement(String.format(template, source));
    }
}
