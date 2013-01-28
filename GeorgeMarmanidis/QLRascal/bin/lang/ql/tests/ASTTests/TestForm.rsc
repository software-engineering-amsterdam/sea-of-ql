@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::tests::ASTTests::TestForm

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Form pForm(str src) = implode(parse(src, |file:///-|));

public test bool testForm1() = pForm("form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean hasBoughtHouse: \"Did you by a house in 2010?\" boolean}") is form;
public test bool testForm2() = pForm("form Box1HouseOwning2 {
   hasSoldHouse: \"Did you sell a house in 2010?\" boolean 
   hasBoughtHouse: \"Did you by a house in 2010?\" boolean
   if(hasSoldHouse){
   		if(addaw){
   		price: \"in what price\" money
   		}
   		price: \"in what price\" money
   		year: \" Which Year \" date
   		}
   	else {
   		soldPlaaning: \"Are you thinking of selling this?\" boolean
   	}
   }") is form;