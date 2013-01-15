form undefinedVariable {
  "Question a)" boolean myBoolA
  if(myBool) {
    "Question b)" integer myInt
  }
  
  if(myBool || (myBoolA && myBool)) {
    "Question c)" integer myInt2
  }
}
