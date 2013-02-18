module typeChecker::TypeEnvironment

import syntax::AbstractSyntax;
import Prelude;

// QLTENV is the type environment for the QL
public alias QLTENV = tuple[ rel[str id, str questionLabel, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors];  

// method to add an error if a syntaz error occur
public QLTENV addError(QLTENV qlTenv, loc l, str msg) = qlTenv[errors = qlTenv.errors + <l, msg>];

// to add an instance of a qltenv item
public QLTENV addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp, bool isComputed) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp,isComputed>}]; 
