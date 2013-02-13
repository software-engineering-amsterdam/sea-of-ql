module typecheckerTests::IntegerTypeCheck

import Prelude;
import typeChecker::TypeEnvironment;
import typeChecker::TypeCheck;
import typeChecker::ExpressionTypeChecker;
import syntax::AbstractSyntax;

private list[tuple[loc l,str msg]] p(str src) = checkProgram(src);

// Tests for easy Questions
public test bool testIntegerSmaller() = p("form Box1 { OwnHouse: \"Do you own a house?\" integer boughtHouse: \"Bought a house?\" integer if(OwnHouse \< boughtHouse) { Remarks: \"Do you have remarks to your house?\" string } }") is QLTENV;
