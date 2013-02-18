/**
 * This module define test functions for each DataType checker function
 * A test function is a boolean function without arguments 
 * it can also be called automatically by the unit test framework, by typing :test    
 * @author  Gerson Delgado
 * @version 1.0, 12/02/2013
 */
module lang::ql::tests::TestMessages

import lang::ql::ide::SemanticChecker::FormChecker;
import lang::ql::util::Implode;
import Message;

loc testFile = |project://QLRascal/src/lang/ql/tests/test.q|;

private set[Message] p(loc l) 
	= checkQl(load(l));

public test set[Message] testFormChecker() 
	= p(testFile);


