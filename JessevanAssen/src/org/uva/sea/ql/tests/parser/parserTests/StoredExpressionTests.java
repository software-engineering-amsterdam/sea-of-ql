package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.parser.ParseError;

import static junit.framework.Assert.assertEquals;

public class StoredExpressionTests extends ParserTests {

    @Test
    public void storedExpressionSignature_storedExpressionIsParsed() throws ParseError {
        final String identifier = "identifier";
        final String expression = "1 + 2";
        final String storedExpressionSignature = "%s = %s";

        Statement parsed = parseStatement(String.format(storedExpressionSignature, identifier, expression));
        assertEquals(StoredExpression.class, parsed.getClass());
        StoredExpression storedExpression = (StoredExpression) parsed;
        assertEquals(identifier, storedExpression.getIdentifier().getName());
        assertEquals(Add.class, storedExpression.getExpression().getClass());
    }

}
