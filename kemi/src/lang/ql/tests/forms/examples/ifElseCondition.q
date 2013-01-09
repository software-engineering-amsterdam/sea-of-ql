form ifCondition {
  "Question one?", integer, numberOne
  if(numberOne == 10) {
  	"Question two?", date, theDate
  } else {
  	"Foo Bar?", string, aText
  }
  "Question three?", money, myFunding
  if(myFunding / 10 == 100) {
  	"Question Four?", string, myText
  } else {
  	"ifelse : else", integer, numberQuestion
  }
}
