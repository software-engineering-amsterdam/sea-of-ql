module tests::TypeTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;

private Type p(str src) = implodeType(parseType(src, |file:///testTypes.q|));

public test bool testType1() = p("boolean") is boolean;
public test bool testType2() = p("integer") is integer;
public test bool testType3() = p("string") is string;
public test bool testType4() = p("money") is money;
// public test bool testType5() = p("money(a)") is money(Expression);