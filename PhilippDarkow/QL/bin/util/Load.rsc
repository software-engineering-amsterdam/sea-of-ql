module util::Load

import Prelude;
import syntax::ConcreteSyntax;
import syntax::AbstractSyntax;
import ParseTree;

/* Method to create an ast
 * @param txt the program as a string
*/
public PROGRAM load(str txt) = implode(#PROGRAM, parse(#Program, txt));

public start[EXP] parse(str src, loc l) = parse(#start[EXP], src, l);