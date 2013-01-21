module abstractSyntax


public data TYPE = Natural()|String()|Bool()|Int();

//public data PROGRAM = program(list[DECL]decls, list[STATEMENT]stats);

//public data PROGRAM = program(EXP exp);
public alias Id = str;  

public data PROGRAM = program(list[DECL] decls, list[Statement] stats);
  
public data DECL =
  decl(Id name, TYPE tp);

//public data DECL = decl(ID name, QuestionID name, TYPE tp);

public data Statement = question(Question question)
						|ifEsleStat(EXP exp , list[Statement] thenPart, list[Statement] elsePart)
						|ifElse(EXP exp , list[Statement] thenPart)
						|ifEsleStat(EXP exp, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart)
						|ifElse(EXP exp,list[Statement] thenPart, list[ElseIf] elseIfs);

public data ElseIf= elsef(EXP exp, list[Statement] thenPart);

public data Question = computed(str identifier, str label, TYPE tp, EXP expression);	

  
public data EXP= id(Question)
					|strCon (str iVal)
					|intCon (int sVal);
				//	|Bool(bool bVal)
				//	|neg(EXP left, EXP right)
				//	|and(EXP left, EXP right)
				//	|or(EXP left, EXP right);						
						
anno loc ElseIf@location;
anno loc Question@location;
anno loc TYPE@location;
anno loc Statement@location;
anno loc PROGRAM@location;

