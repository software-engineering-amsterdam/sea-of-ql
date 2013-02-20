package org.uva.sea.ql.parsing.statement;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QuestionTest extends TestParser {

    @Test
    public void shouldEvaluateToQuestionClass() throws ParseException {
        Statement question = parseStatement("overEighteen : \"Are you 18 years or older?\" boolean");
        assertEquals(Question.class, question.getClass());
        assertEquals(BooleanType.class, ((Question) question).getDatatype().getClass());
    }

    @Test
    public void shouldHaveDatatypeBool() throws ParseException {
        Question question = (Question) parseStatement("overEighteen : \"Are you 18 years or older?\" boolean");
        assertEquals(BooleanType.class, question.getDatatype().getClass());
    }

    @Test
    public void shouldHaveDatatypeInt() throws ParseException {
        Question question = (Question) parseStatement("age : \"How old are you?\" integer");
        assertEquals(IntegerType.class, question.getDatatype().getClass());
    }

    @Test
    public void shouldHaveDatatypeStr() throws ParseException {
        Question question = (Question) parseStatement("birthPlace : \"What is your place of birth?\" string");
        assertEquals(StringType.class, question.getDatatype().getClass());
    }

    @Test
    public void shouldNotAcceptOtherType() throws ParseException {
        Question question = (Question) parseStatement("salary : \"What is your gross salary?\" money");
        assertNull(question);
    }
}
