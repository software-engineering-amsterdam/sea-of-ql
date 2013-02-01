package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.uva.sea.ql.interpreter.InterpreterVisitor;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class InterpreterVisitorTests {

    protected final InterpreterVisitor visitor;
    protected final InterpreterVisitor.Context context;

    protected InterpreterVisitorTests() {
        visitor = createInstanceOfVisitor();
        context = createInstanceOfContext();
    }

    private InterpreterVisitor createInstanceOfVisitor() {
        try{
            Constructor<InterpreterVisitor> visitorConstructor = InterpreterVisitor.class.getDeclaredConstructor();
            visitorConstructor.setAccessible(true);
            return visitorConstructor.newInstance();
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private InterpreterVisitor.Context createInstanceOfContext() {
        try{
            Constructor<InterpreterVisitor.Context> contextConstructor = InterpreterVisitor.Context.class.getDeclaredConstructor(Map.class);
            contextConstructor.setAccessible(true);
            return contextConstructor.newInstance(new HashMap<String, String>());
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
