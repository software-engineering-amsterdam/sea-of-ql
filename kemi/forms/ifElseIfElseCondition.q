form ifCondition {
  "Question one?", integer, numberOne
  if(numberOne == 10) {
  	"Question two?", date, theDate
  } elseif (a == b) {
  	// We also have else if statements.
  	"Foo Bar?", string, aText
  } elseif (c == d) {
  	// They can be arbitrarily nested
  	"Blah?", string, bText
  } else {
  	// And even contain an else!
  	"santhuonhaunosau?", string, cText
  }
}
