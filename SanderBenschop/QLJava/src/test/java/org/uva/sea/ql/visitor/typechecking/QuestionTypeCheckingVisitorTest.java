package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.ast.binary.EqualTo;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;

import static junit.framework.Assert.assertTrue;

public class QuestionTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() throws IllegalAccessException {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldMakeIdentifierReducableToOwnType() {
        Question question = new Question(new Ident("age"), new Str("\"How old are you?\""), Int.class);
        Int otherNumber = new Int(20);
        BinaryOperation twentyYearsOld = new EqualTo(new Ident("age"), otherNumber);

        typeCheckingVisitor.visitQuestion(question);
        typeCheckingVisitor.visitDatatype(otherNumber);
        typeCheckingVisitor.visitBinaryOperation(twentyYearsOld);

        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
    }
}
