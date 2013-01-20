package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Declaration;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Type;

import static org.junit.Assert.assertEquals;

public class QuestionTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String QUESTION_LABEL = "question label";
    private static final String IDENTITY_NAME = "abcde";

    @Test
    public void questionVisited_questionAddedToStringBuilder() {
        createQuestion(new Bool()).accept(visitor, context);
        assertEquals(
                String.format("new Question(\"%s\",\"%s\",DataType.BOOLEAN)", QUESTION_LABEL, IDENTITY_NAME),
                context.getObjectHierarchy().toString()
        );
    }


    private Question createQuestion(Type type) {
        return new Question(
                QUESTION_LABEL,
                new Declaration(
                        new Ident(IDENTITY_NAME),
                        type
                )
        );
    }
}
