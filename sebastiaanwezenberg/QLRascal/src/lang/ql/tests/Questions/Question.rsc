module lang::ql::tests::Questions::Question

import lang::ql::tests::TestHelper;

public test bool testQuestion1() 
	= pq("\"Did you sold the house?\" boolean soldHouse") is question
	;

public test bool testQuestion2() 
	= pq("\"TestQuestion?\" boolean testBool") is question
	;

public test bool testQuestion3() 
	= pq("\"Test question?\" money saldo = myFieldName - 500") is question
	;
