package org.uva.sea.ql.parser.stringparsing.formelement;

import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestConditionals extends TestParser {

    @Test
    public void shouldEvaluateToConditionalClass() throws ParseError {
        assertEquals(Conditional.class, parseStatement("if(1==2){}").getClass());
        assertEquals(Conditional.class, parseStatement("if(1==2){} else {}").getClass());
    }

    @Test
    public void shouldHaveEmptyBlocks() throws ParseError {
        Conditional ifStatement = (Conditional) parseStatement("if(1==2){}"), ifElseStatement = (Conditional) parseStatement("if(1==2){} else {}");
        assertEquals(0, ifStatement.getSuccessBlock().size());
        assertEquals(0, ifStatement.getFailureBlock().size());
        assertEquals(0, ifElseStatement.getSuccessBlock().size());
        assertEquals(0, ifElseStatement.getFailureBlock().size());
    }

    @Test
    public void shouldNotHaveDanglingElseProblemBecauseOfMandatoryBrackets() throws ParseError {
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

    private void assertOuterConditional(String parseText) throws ParseError {
        Conditional outerConditional = (Conditional) parseStatement(parseText);
        List<QLStatement> outerSuccessBlock = outerConditional.getSuccessBlock(), outerFailureBlock = outerConditional.getFailureBlock();
        assertEquals(1, outerSuccessBlock.size());
        assertEquals(1, outerFailureBlock.size());

        //Outer successBlock contains inner conditional block.
        assertInnerConditional((Conditional) outerSuccessBlock.get(0));

        //Outer failureBlock contains Question with identifier name q3.
        Question outerFailureQuestion = (Question) outerFailureBlock.get(0);
        assertEquals("q3", outerFailureQuestion.getIdentifier().getName());
    }

    private void assertInnerConditional(Conditional innerConditional) {
        List<QLStatement> innerSuccessBlock = innerConditional.getSuccessBlock(), innerFailureBlock = innerConditional.getFailureBlock();
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
