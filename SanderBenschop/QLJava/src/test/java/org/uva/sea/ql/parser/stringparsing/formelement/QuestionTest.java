package org.uva.sea.ql.parser.stringparsing.formelement;

import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.formelement.Question;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QuestionTest extends TestParser {

    @Test
    public void shouldEvaluateToQuestionClass() throws ParseError {
    	QLStatement question = parseStatement("overEighteen : \"Are you 18 years or older?\" boolean");
        assertEquals(Question.class, question.getClass());
        assertEquals(Bool.class, ((Question) question).getDatatype());
    }

    @Test
    public void shouldHaveDatatypeBool() throws ParseError {
    	Question question = (Question) parseStatement("overEighteen : \"Are you 18 years or older?\" boolean");
        assertEquals(Bool.class, question.getDatatype());
    }

    @Test
    public void shouldHaveDatatypeInt() throws ParseError {
    	Question question = (Question) parseStatement("age : \"How old are you?\" integer");
        assertEquals(Int.class, question.getDatatype());
    }

    @Test
    public void shouldHaveDatatypeStr() throws ParseError {
        Question question = (Question) parseStatement("birthPlace : \"What is your place of birth?\" string");
        assertEquals(Str.class, question.getDatatype());
    }

    @Test
    public void shouldNotAcceptOtherType() throws ParseError {
        Question question = (Question) parseStatement("salary : \"What is your gross salary?\" money");
        assertNull(question);
    }
}
