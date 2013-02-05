form proposedSyntax {
  "Question ten?"
    boolean questionTen
  "Question five?"
    integer questionFive
  
  if(questionTen) {
    "Question four"
      money questionFour
    if(questionFour * 3 > 100 || questionFour < 20) {
      "Question six"
        boolean questionSix
    }
    "Question seven"
      money questionSeven = questionFive - questionFour
  } else if(questionFive > 100) {
    "Question one?"
      boolean questionOne
  } else {
    "Question two"
      money questionTwo
    
    "Question three"
      money questionThree = questionTwo / 2
  }
}
