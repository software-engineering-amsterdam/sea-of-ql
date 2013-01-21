module util::Implode

import ParseTree;
import util::Load;
import syntax::AbstractSyntax;
import IO;
import Prelude;


public Expression implode(Tree t) {
 println("TREE : <t>");
 return implode(#Expression, t);
 }

public Expression load(loc l) = implode(parse(readFile(l), l));