package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.visitor.typechecking.error.UnsupportedTypeError;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.*;

public class ConditionalTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true, sourceCodeInformation);
        List<QLStatement> emptyStatementList = Collections.emptyList();
        IfStatement conditional = new IfStatement(expression, emptyStatementList);

        boolean ifStatementCorrect = typeCheckingVisitor.visitIfStatement(conditional);
        assertEquals(0, typeCheckingVisitor.getErrors().size());
        assertTrue(ifStatementCorrect);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0, sourceCodeInformation);
        List<QLStatement> emptyStatementList = Collections.emptyList();
        IfStatement conditional = new IfStatement(expression, emptyStatementList);

        boolean ifStatementCorrect = typeCheckingVisitor.visitIfStatement(conditional);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(ifStatementCorrect);
    }
}
