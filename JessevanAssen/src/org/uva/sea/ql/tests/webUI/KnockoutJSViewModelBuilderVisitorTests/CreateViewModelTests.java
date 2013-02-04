package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Boolean;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class CreateViewModelTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final Form FORM = new Form(
            new Identifier("a"),
            new CompositeStatement(
                    Arrays.asList(
                            (Statement) new Question("a", new Identifier("a"), new Boolean()),
                            (Statement) new Question("b", new Identifier("b"), new Boolean()),
                            (Statement) new Question("c", new Identifier("c"), new org.uva.sea.ql.ast.type.Boolean())
                    )
            )
    );

    @Test
    public void methodCalled_identifiersAreAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);

        assertTrue(viewModel.contains(
                "identifiers={a:ko.observable(),b:ko.observable(),c:ko.observable()}"
        ));
    }

    @Test
    public void methodCalled_formIsAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);
        FORM.accept(visitor, context);
        assertTrue(viewModel.contains("root=" + context.getObjectHierarchy().toString()));
    }

}
