package org.uva.sea.ql.parser.stringparsing.statement;

import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.StringType;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QuestionTest extends TestParser {

    @Test
    public void shouldEvaluateToQuestionClass() throws ParseException {
        QLStatement question = parseStatement("overEighteen : \"Are you 18 years or older?\" boolean");
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
