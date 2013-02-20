package org.uva.sea.ql.parsing;

import junit.framework.Assert;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.statement.Conditional;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parsing.exception.ParseException;

public abstract class TestParser {

    protected Statement parseStatement(String source) throws ParseException {
        String template = "form FormName { %s }";
        Form form = new FormParser().parse(String.format(template, source)).getForm();
        return form.getStatements().get(0);
    }

    protected Expression parseExpression(String source) throws ParseException {
        Conditional statement = wrapInConditionalAndParse(source);
        Assert.assertTrue("Attempted to parse non-expression to an expression.", statement.getCondition() instanceof Expression);
        return statement.getCondition();
    }

    protected Ident parseIdent(String source) throws ParseException {
        Conditional statement = wrapInConditionalAndParse(source);
        Assert.assertTrue("Attempted to parse non-ident to an ident.", statement.getCondition() instanceof Ident);
        return (Ident) statement.getCondition();

    }

    protected Expression parsePrimary(String source) throws ParseException {
        String template = "if(%s){}";
        Conditional statement = (Conditional) parseStatement(String.format(template, source));
        return statement.getCondition();
    }

    private Conditional wrapInConditionalAndParse(String source) throws ParseException {
        String template = "if(%s){}";
        return (Conditional) parseStatement(String.format(template, source));
    }
}
