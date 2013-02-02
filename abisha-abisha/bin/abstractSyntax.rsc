module AbstractSyntax

public data TYPE = natural() | string()|money()|boolean();    
	  
public alias QuestionireId = str;      
public alias QuestionireString = str;
public alias Money = int;            
	  
public data FORM = form(list[DECL] decls, list[STATEMENT] stats);

public data DECL = decl(QuestionireId name, TYPE tp);

public data EXP = id(QuestionireId name)
     | natCon(int iVal)
     | strCon(str sVal)
     | money(int iVal)
     | add(EXP left, EXP right)
     | sub(EXP left, EXP right)
     ;
    
public data STATEMENT = asgStat(QuestionireId name, EXP exp)
     | ifElseStat(EXP exp, list[STATEMENT] thenpart, list[STATEMENT] elsepart)
     ;

anno loc TYPE@location;                   
anno loc FORM@location;
anno loc DECL@location;
anno loc EXP@location;
anno loc STATEMENT@location;

public alias Occurrence = tuple[loc location, QuestionireId name, STATEMENT stat];  
