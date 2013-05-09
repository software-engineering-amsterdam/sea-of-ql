module load::Implode

import ParseTree;
import load::Load;
import syntax::Abstract;
import load::Parse;
import IO;
import Prelude;

public Expression implodeExpression(Tree t) = implode(#Expression, t);

public Statement implodeStatement(Tree t) = implode(#Statement, t);

public Question implodeQuestion(Tree t) = implode(#Question, t);

public Type implodeType(Tree t) = implode(#Type, t);

public Form implodeForm(Tree t) = implode(#Form, t);
