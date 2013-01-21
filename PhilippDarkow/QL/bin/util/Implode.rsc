module util::Implode

import ParseTree;
import util::Load;
import syntax::AbstractSyntax;
import IO;
import Prelude;

public Expression implode(Tree t) = implode(#Expression, t);
public Expression load(loc l) = implode(parse(readFile(l), l));

public Statement implode(Tree t) = implode(#Statement, t);
public Statement load(loc l) = implode(parse(readFile(l), l));

public Question implode(Tree t) = implode(#Question, t);
public Question load(loc l) = implode(parse(readFile(l), l));