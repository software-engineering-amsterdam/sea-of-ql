module lang::ql::tests::Forms::Outline

import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::tests::TestHelper;

private node outline(loc l) 
	= outlineModule(parseForm(l))
	;

public test bool testOutline() 
	= outline(|project://QL-R//src/lang/ql/tests/Forms/Form1.q|) > "outline"()
	;
  
