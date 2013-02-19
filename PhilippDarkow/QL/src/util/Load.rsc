module util::Load

import Prelude;
import syntax::ConcreteSyntax;
import syntax::AbstractSyntax;
import ParseTree;

/* Method to create an ast
 * @param txt the program as a string
*/
public Program load(str txt) = implode(#Program, parse(#start[Program], txt));