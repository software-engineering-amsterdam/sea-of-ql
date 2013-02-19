package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.visitor.typechecking.ReductionTable;
import org.uva.sea.ql.visitor.typechecking.TypeCheckingVisitor;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierTypeCheckingVisitorTest {

    @Mock
    private ReductionTable mockedReductionTable;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() throws IllegalAccessException {
        typeCheckingVisitor = new TypeCheckingVisitor(mockedReductionTable);
    }

    @Test
    public void shouldNotThrowIdentifierRedeclarationError() {
        Ident ident = new Ident("age");
        typeCheckingVisitor.visitIdent(ident);
        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
    }

    @Test
    public void shouldThrowIdentifierRedeclarationError() {
        String computationName = "grossIncome";
        Ident ident = new Ident(computationName);
        when(mockedReductionTable.containsReductionFor(ident)).thenReturn(true);

        typeCheckingVisitor.visitIdent(ident);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof IdentifierRedeclarationError);
    }
}
