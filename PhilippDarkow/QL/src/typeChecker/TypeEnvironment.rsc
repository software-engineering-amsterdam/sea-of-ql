module typeChecker::TypeEnvironment

import syntax::AbstractSyntax;

public alias QLTENV = tuple[ rel[str id, str questionLabel, Type tp] question, list[tuple[loc l, str msg]] errors];

public QLTENV addError(QLTENV qlTenv, loc l, str msg) = qlTenv[errors = qlTenv.errors + <l, msg>];
// to add an instance of a qltenv item
public QLTENV addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp>}]; //= qlTenv.errors + <l, msg> 
