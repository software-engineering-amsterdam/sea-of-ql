package org.uva.sea.ql.parser.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.BinaryOperation;
import org.uva.sea.ql.ast.nodetypes.binary.EqualTo;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Str;

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
