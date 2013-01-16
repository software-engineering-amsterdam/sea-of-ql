module lang::ql::tests::ASTTests::TestForm

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Form p(str src) = implode(parse(src, |file:///-|));

public test bool testForm1() = p("form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you by a house in 2010?\" boolean}") is form;
public test bool testForm2() = p("form Box1HouseOwning2 {
   hasSoldHouse: \"Did you sell a house in 2010?\" boolean 
   hasBoughtHouse: \"Did you by a house in 2010?\" boolean
   if(hasSoldHouse){
   		price: \"in what price\" money
   		year: \" Which Year \" date
   		}
   	else {
   		soldPlaaning: \"Are you thinking of selling this?\" boolean
   	}
   }") is form;