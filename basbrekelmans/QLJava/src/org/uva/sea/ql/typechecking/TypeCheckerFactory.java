package org.uva.sea.ql.typechecking;

/**
 * Provides static methods to instantiate an ITypeResolver or an ITypeChecker.
 * (Factory Method)
 */
public final class TypeCheckerFactory {

	/**
	 * No static modifier allowed on classes. Therefore a private constructor to
	 * prevent instantiation.
	 */
	private TypeCheckerFactory() {
	}

	public static ITypeResolver createTypeResolver() {
		return createTypeResolverImpl(new TypeContext());
	}

	public static ITypeChecker createTypeChecker() {
		TypeContext context = new TypeContext();
		ITypeResolver resolver = createTypeResolverImpl(context);
		return new TypeChecker(context, resolver);
	}

	private static ITypeResolver createTypeResolverImpl(TypeContext context) {
		return new TypeResolver(context);
	}
}
