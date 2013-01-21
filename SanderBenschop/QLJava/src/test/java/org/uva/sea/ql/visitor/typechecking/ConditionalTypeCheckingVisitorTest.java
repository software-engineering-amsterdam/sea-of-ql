package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.visitor.typechecking.TypeCheckingVisitor;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ConditionalTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true);
        List<QLStatement> emptyStatementList = Collections.emptyList();
        Conditional conditional = new Conditional(expression, emptyStatementList);
        typeCheckingVisitor.visitDatatype(expression);
        typeCheckingVisitor.visitConditional(conditional);

        assertEquals(0, typeCheckingVisitor.getErrors().size());
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0);
        List<QLStatement> emptyStatementList = Collections.emptyList();
        Conditional conditional = new Conditional(expression, emptyStatementList);
        typeCheckingVisitor.visitDatatype(expression);
        typeCheckingVisitor.visitConditional(conditional);

        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
    }
}
