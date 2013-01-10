form ifCondition {
  "Question one?", integer, numberOne
  if(numberOne == 10) {
  	"Question two?", date, theDate
  }
  "Question three?", money, myFunding
  if(myFunding / 10 == 100) {
  	"Question Four?", string, myText
  }
}
