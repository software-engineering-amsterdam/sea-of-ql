module syntax::abstractSyntax

alias QuestionireId=str;
alias QuestionireString= str;

public data Type = string()|integer()|money()|natural();


public data Program= program(str qLangName, list[Statement]body);

public data Question=uncomputedQuestion(str id, str labelQuestion, Type tp)
				|computedQuestion(str id, str labelQuestion, Type tp, Expression exp);
				
public data Expression= id(str name)
				| \int(int ivalue)
				| \bool(bool boolean)
				| add (Expression left, Expression right)
				| mul (Expression left, Expression right)
				| div (Expression left, Expression right)
				| sub (Expression left, Expression right)
				| and (Expression left, Expression right)
				| or (Expression left, Expression right)
				| lt (Expression left, Expression right)
				| leq (Expression left, Expression right)
				| gt (Expression left, Expression right)
				| geq (Expression left, Expression right)
				| eq (Expression left, Expression right)
				| neq (Expression left, Expression right)
				| boolCon (bool bVal)
				| moneyCon (str mVal)
				| string (str sVal)
				;
				
public data Statement = ifStat(Expression exp, list[Statement]body)
				|ifElseStat(Expression exp, list[Statement] thenpart, list[Statement] elsepart)
				|question(Question question);
				
anno loc Type@location;                   
anno loc Program@location;
anno loc Expression@location;
anno loc Statement@location;
anno loc Question@location;

public alias Occurrence = tuple[loc location, str name, Statement stat]; 
   