package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.type.Boolean;

import java.lang.String;

import static org.junit.Assert.assertEquals;

public class QuestionTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String QUESTION_LABEL = "question label";
    private static final String IDENTIFIER_NAME = "abcde";

    @Test
    public void questionVisited_questionAddedToStringBuilder() {
        createQuestion(new org.uva.sea.ql.ast.type.Boolean()).accept(visitor, context);
        assertEquals(
                String.format("new Question(\"%s\",\"%s\",_self.identifiers.%s,DataType.BOOLEAN)", QUESTION_LABEL, IDENTIFIER_NAME, IDENTIFIER_NAME),
                context.getObjectHierarchy().toString()
        );
    }

    @Test
    public void questionVisited_addVariableToIdentifierMap() {
        createQuestion(new Boolean()).accept(visitor, context);
        assertEquals(
                String.format("%s:ko.observable()", IDENTIFIER_NAME),
                context.getIdentifiers().get(0)
        );
    }


    private Question createQuestion(Type type) {
        return new Question(
                QUESTION_LABEL,
                new Identifier(IDENTIFIER_NAME),
                type
        );
    }
}
