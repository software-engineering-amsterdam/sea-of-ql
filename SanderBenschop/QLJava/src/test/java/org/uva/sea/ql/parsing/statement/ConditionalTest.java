package org.uva.sea.ql.parsing.statement;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.parsing.exception.ParseException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConditionalTest extends TestParser {

    @Test
    public void shouldEvaluateToConditionalClass() throws ParseException {
        assertEquals(IfStatement.class, parseStatement("if(1==2){}").getClass());
        assertEquals(IfElseStatement.class, parseStatement("if(1==2){} else {}").getClass());
    }

    @Test
    public void shouldHaveEmptyBlocks() throws ParseException {
        IfStatement ifStatement = (IfStatement) parseStatement("if(1==2){}");
        IfElseStatement ifElseStatement = (IfElseStatement) parseStatement("if(1==2){} else {}");
        assertEquals(0, ifStatement.getSuccessBlock().size());
        assertEquals(0, ifElseStatement.getSuccessBlock().size());
        assertEquals(0, ifElseStatement.getFailureBlock().size());
    }

    @Test
    public void shouldNotHaveDanglingElseProblemBecauseOfMandatoryBrackets() throws ParseException {
        String parseText = "if(true) {" +       //Outer conditional & successBlock start
                "if(false) {" + //Inner conditional & successBlock start
                "q1 : \"What is 2*2?\" integer" +
                "} else {" +    //Inner successBlock end & failureBlock start
                "q2 : \"What is 1+1?\" integer" +
                "}" +           //Inner failureBlock end
                "} else {" +        //Outer successBlock end & failureBlock start
                "q3 : \"What is 2^9?\" integer" +
                "}";                //Outer failureBlock & conditional end

        assertOuterConditional(parseText);
    }

    private void assertOuterConditional(String parseText) throws ParseException {
        IfElseStatement outerConditional = (IfElseStatement) parseStatement(parseText);
        List<Statement> outerSuccessBlock = outerConditional.getSuccessBlock(), outerFailureBlock = outerConditional.getFailureBlock();
        assertEquals(1, outerSuccessBlock.size());
        assertEquals(1, outerFailureBlock.size());

        //Outer successBlock contains inner conditional block.
        assertInnerConditional((IfElseStatement) outerSuccessBlock.get(0));

        //Outer failureBlock contains Question with identifier name q3.
        Question outerFailureQuestion = (Question) outerFailureBlock.get(0);
        assertEquals("q3", outerFailureQuestion.getIdentifier().getName());
    }

    private void assertInnerConditional(IfElseStatement innerConditional) {
        List<Statement> innerSuccessBlock = innerConditional.getSuccessBlock(), innerFailureBlock = innerConditional.getFailureBlock();
        assertEquals(1, innerSuccessBlock.size());
        assertEquals(1, innerFailureBlock.size());

        //Inner successBlock contains Question with identifier name q1
        Question innerSuccessQuestion = (Question) innerSuccessBlock.get(0);
        assertEquals("q1", innerSuccessQuestion.getIdentifier().getName());

        //Inner failureBlock contains Question with identifier name q2
        Question innerFailureQuestion = (Question) innerFailureBlock.get(0);
        assertEquals("q2", innerFailureQuestion.getIdentifier().getName());
    }
}
