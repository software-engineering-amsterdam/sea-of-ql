package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.uva.sea.ql.typechecker.TypecheckerVisitor;

import java.lang.reflect.Constructor;

public abstract class TypecheckerVisitorTests {

	protected final TypecheckerVisitor visitor;
	protected final TypecheckerVisitor.Context context;
	
	public TypecheckerVisitorTests() {
		visitor = createTypecheckerVisitor();
		context = new TypecheckerVisitor.Context();
	}

    private TypecheckerVisitor createTypecheckerVisitor() {
        try{
            Constructor<TypecheckerVisitor> constructor = TypecheckerVisitor.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception x) {
            throw new RuntimeException("Problems occurred while creating a new instance of the TypecheckerVisitor using reflection.", x);
        }
    }
	
}
