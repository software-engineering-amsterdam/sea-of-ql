package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Declaration;
import org.uva.sea.ql.ast.Question;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuestionTests extends TypecheckerVisitorTests {

    @Test
    public void acceptIsCalled_declarationAcceptIsCalled() {
        Declaration mockDeclaration = mock(Declaration.class);
        Question question = new Question("a", mockDeclaration);
        question.accept(visitor, context);
        verify(mockDeclaration).accept(visitor, context);
    }

}
