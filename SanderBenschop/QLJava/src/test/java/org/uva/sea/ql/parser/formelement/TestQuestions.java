package org.uva.sea.ql.parser.formelement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestQuestions extends TestParser {

    @Test
    public void shouldEvaluateToQuestionClass() throws ParseError {
        assertEquals(Question.class, parseStatement("ageCheck : \"Are you 18 years or older?\" boolean").getClass());
    }
}
