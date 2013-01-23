package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.uva.sea.ql.webUI.KnockoutJSViewModelBuilderVisitor;

import java.lang.reflect.Constructor;

public abstract class KnockoutJSViewModelBuilderVisitorTests {
    protected final KnockoutJSViewModelBuilderVisitor visitor;
    protected final KnockoutJSViewModelBuilderVisitor.Context context;

    public KnockoutJSViewModelBuilderVisitorTests() {
        visitor = createVisitor();
        context = new KnockoutJSViewModelBuilderVisitor.Context();
    }

    private KnockoutJSViewModelBuilderVisitor createVisitor() {
        try{
            Constructor<KnockoutJSViewModelBuilderVisitor> constructor = KnockoutJSViewModelBuilderVisitor.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception x) {
            throw new RuntimeException("Problems occurred while creating a new instance of the KnockoutJSViewModelBuilderVisitor using reflection.", x);
        }
    }
}
