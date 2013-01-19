package org.uva.sea.ql.parser.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.parser.visitor.typechecking.TypeCheckingError;

public class TestTypeCheckingError {

    @Test
    public void shouldGetTypeErrorMessage() {
        int line = 0;
        ASTNode expectedType = new Int(0);
        ASTNode actualType = new Bool(false);

        TypeCheckingError error = new TypeCheckingError(line, expectedType.getClass().getSimpleName(), actualType.getClass().getSimpleName());
        String errorMessage = "Error: variable on line 0 of type Bool was expected to be reduceable to Int.";
        assertEquals(errorMessage, error.getErrorMessage());
    }
}
