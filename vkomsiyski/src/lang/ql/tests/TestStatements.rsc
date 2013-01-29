module lang::ql::tests::TestStatements

import lang::ql::ast::AST;
import lang::ql::util::Implode;

 
public test bool testRegular1() 
  = loadStatement(
      "bool sellingPrice =\"Price the house was sold for:\""
    ) is regular;
 
public test bool testRegular2() 
  = loadStatement(
      "int hh3=\"How are you?\""
    ) is regular;

public test bool testRegular3() 
  = loadStatement(
      "float Float=\"debts=\""
    ) is regular;

public test bool testComputed1() 
  = loadStatement(
      "int valueResidue =  \"Value residue:\"(sellingPrice - privateDebt)"
    ) is computed; 

public test bool testComputed1() 
  = loadStatement(
      "bool name = \"name\"5*6+(38-16)/2 && 5"
    ) is computed; 

public test bool testConditional1() 
  = loadStatement(
      "if (!x) { bool x = \"AreYouSure?\"}"
	) is conditional;

public test bool testConditional2() 
  = loadStatement(
      "if (a) { 
         bool a1 = \"really?\" yes || maybe
	   } else if (b)  {
	     bool b1 = \"haha\"
	   } else {
	     bool e1 = \"meh\"
	   }"  
	) is conditional;
	   
public test bool testConditional3() 
  = loadStatement(
      "if (j \> k) { 
         float rate = \"rate?\" 
         date hours = \"hours?\"
         string salary = \"salary=\" rate*hours 
	   } else {
	     float salary = \"salary=\" old_salary 
	   }"
	) is conditional;
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   