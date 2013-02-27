stylesheet undefinedQuestions {
  question def
  question undef
  question alsoUndef
  
  default boolean {
    widget number
    width 100
  }
  
  default date {
    widget slider
    width 200
    fontsize 10
    font "Times New Roman"
    color #FF0000
  }
  
  default integer {
    widget slider[0, 1, 0.01]
  }
}
