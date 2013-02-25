module load::Implode

import ParseTree;
import load::Load;
import syntax::Abstract;
import load::Parse;
import IO;
import Prelude;

public Expression implodeExpression(Tree t) = implode(#Expression, t);
public Expression load(loc l) = implode(parse(readFile(l), l));

public Statement implodeStatement(Tree t) = implode(#Statement, t);
public Statement load(loc l) = implode(parse(readFile(l), l));

public Question implodeQuestion(Tree t) = implode(#Question, t);
public Question load(loc l) = implode(parse(readFile(l), l));

public Type implodeType(Tree t) = implode(#Type, t);
public Type load(loc l) = implode(parse(readFile(l), l));

public Form implodeForm(Tree t) = implode(#Form, t);

public Form load(loc l) = implode(parse(readFile(l), l));