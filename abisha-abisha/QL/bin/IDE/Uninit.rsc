module IDE::Uninit

import Prelude;
import syntax::abstractSyntax;
import load::Load;

import Visualization::UseDef;
import Visualization::ControlFlow;

public set[CFNode] defNodes(QuestionId Id, set[Occurrence]Defs)={statement(Occ.stat@location,occ.stat)|Occurrence occ<-Defs,occ.name==id};

public set[Occurrence] uninitProgram(PROGRAM)
{
	d=Defs(P);
	CFG=cflowProgram(P);
	return
		{
		occ|occ <-uses(P),any(CFNode N<-reachX(CFG.grapgh,CFG,entry, defNodes(occ.name, D)),
		N has location && occ.location<=N.location)
		};
}
	
public set[Occurrence] uninitProgram(str txt)=uninitProgram(load(txt));