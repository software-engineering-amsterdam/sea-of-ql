module lang::ql::tests::GrammarTests::TestForm

import lang::ql::syntax::QL;
import ParseTree;

public start[Form] parseForm(str src) = parse(#start[Form], src, |file:///-|);

public test bool testForm1() = parseForm("form box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you by a house in 2010?\" boolean}") is form;
public test bool testForm2() = parseForm(
"form Box1HouseOwning {
hasSoldHouse: \"Did you sell a house in 2010?\" boolean
hasBoughtHouse: \"Did you by a house in 2010?\" boolean
if(hasSoldHouse\<10) {hasBoughtHouse: \"Did you by a house in 2010?\" boolean}}") is form;