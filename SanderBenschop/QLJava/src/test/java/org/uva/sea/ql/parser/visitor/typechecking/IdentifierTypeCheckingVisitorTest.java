package org.uva.sea.ql.parser.visitor.typechecking;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierTypeCheckingVisitorTest {

    @Mock
    private ReductionTable mockedReductionTable;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() throws IllegalAccessException {
        typeCheckingVisitor = new TypeCheckingVisitor();
        typeCheckingVisitor.setReductionTable(mockedReductionTable);
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
