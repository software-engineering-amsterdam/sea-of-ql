form SSSSS {
  "What is your number?", integer, numberQuestion
  /* This is broken..., see QL.rsc @ line 14-15 */
  /*"3x your number is", integer, numberx3: numberQuestion * 3*/
  if (a + b) {
  	"if", integer, numberQuestion
  	"if2", date, myDate
  }
  
  if (a + b) {
  	"ifelse: if", integer, numberQuestion
  } else {
  	"ifelse : else", integer, numberQuestion
  }
}
