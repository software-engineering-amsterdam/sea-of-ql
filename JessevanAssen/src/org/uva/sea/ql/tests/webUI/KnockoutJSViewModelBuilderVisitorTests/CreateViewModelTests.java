package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class CreateViewModelTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final Form FORM = new Form(
            new Ident("a"),
            new CompositeFormElement(
                    Arrays.asList(
                            (FormElement) new Question("a", new Declaration(new Ident("a"), new Bool())),
                            (FormElement) new Question("b", new Declaration(new Ident("b"), new Bool())),
                            (FormElement) new Question("c", new Declaration(new Ident("c"), new Bool()))
                    )
            )
    );

    @Test
    public void methodCalled_identitiesAreAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);

        assertTrue(viewModel.contains(
                "identities={a:ko.observable(),b:ko.observable(),c:ko.observable()}"
        ));
    }

    @Test
    public void methodCalled_formIsAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);
        FORM.accept(visitor, context);
        assertTrue(viewModel.contains("root=" + context.getObjectHierarchy().toString()));
    }

}
