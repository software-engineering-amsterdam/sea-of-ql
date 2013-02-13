stylesheet defaultRedefinition {
  section "S1" {
    question int
    
    default integer {
      width 100
    }
  }

  default boolean {
    widget checkbox
  }
  default boolean {
    widget radio
  }
  
  default integer {
    width 200
  }
}
