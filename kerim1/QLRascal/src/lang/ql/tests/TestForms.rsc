module lang::ql::tests::TestForms

import lang::ql::util::Implode;

loc testFile = |project://QLRascal/src/lang/ql/tests/test.q|;

public test bool testForm1() = load("form test1 { }") is form;
public test bool testForm2() = load("form test2 {
									'	abc: \"def\" bool
									'	if (abc) {
									'		def: \"ghi\" int
									'	}
									'}") is form;

public test bool testForm3() = load(testFile) is form;
