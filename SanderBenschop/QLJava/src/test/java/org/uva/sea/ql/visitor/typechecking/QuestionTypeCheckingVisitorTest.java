package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.binary.EqualTo;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.statement.Question;

import static junit.framework.Assert.assertTrue;

public class QuestionTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() throws IllegalAccessException {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldMakeIdentifierReducableToOwnType() {
        Question question = new Question(new Ident("age"), new Str("\"How old are you?\""), new IntegerType());
        Int otherNumber = new Int(20);
        EqualTo twentyYearsOld = new EqualTo(new Ident("age"), otherNumber);

        boolean questionCorrect = typeCheckingVisitor.visitQuestion(question);
        boolean equalToCorrect = typeCheckingVisitor.visitEqualTo(twentyYearsOld);

        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(questionCorrect);
        assertTrue(equalToCorrect);
    }
}
