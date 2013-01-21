module tests::TypeTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;
//import lang::ql::syntax::QL;

private Type p(str src) = implodeType(parseType(src, |file:///testTypes.q|));

// public start[Type] parseType(str src) = parse(#start[Type], src, |file:///-|);

public test bool testType1() = p("boolean") is boolean;
public test bool testType2() = p("integer") is integer;
public test bool testType3() = p("string") is string;
public test bool testType4() = p("money") is money;