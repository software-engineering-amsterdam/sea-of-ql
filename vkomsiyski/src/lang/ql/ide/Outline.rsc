module lang::ql::ide::Outline

import lang::ql::ast::AST;
import util::IDE;


public node outlineForm(Form form) {

	n = "Form"("meh");
	n@\loc = form@location;
	n@label = "basi";
	return n;
}

node outline(Form form) = "outline"(outline(form.name));

node outline(str name) = "form"[@label=name];

/*
node outline(list[Event] es) = "events"([ outline(e) | e <- es])[@label="Events"];

// todo: pass env around to lookup resets
// node outline(list[str] rs) = "resets"([ outline(e) | e <- es])[@label="Reset Events"];

node outline(list[Command] cs) = "commands"([ outline(c) | c <- cs])[@label="Commands"];

node outline(list[State] ss) = "states"([ outline(s) | s <- ss])[@label="States"];

node outline(e:event(n, t)) = "event"()[@label="<n> <t>"][@\loc=e@location];

node outline(c:command(n, t)) = "command"()[@label="<n> <t>"][@\loc=c@location];

node outline(s:state(n, as, ts)) = "state"([ outline(t) | t <- ts ])[@label=n][@\loc=s@location];

// todo: pass env around to lookup state locs.
node outline(t:transition(e, s)) = "transition"()[@label="<e> -\> <s>"][@\loc=t@location];
*/

