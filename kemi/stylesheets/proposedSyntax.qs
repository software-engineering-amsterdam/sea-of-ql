page .pageOne {
  $sectionOne
  #fieldThree
}

section $sectionOne {
  #fieldOne
  section $sectionTwo {
    #fieldTwo
    #fieldFour
    section $sectionThree {
      #fieldFive
    }
  }
}

boolean {
  type checkbox
}

.pageOne {
  type radio
}

$sectionOne {
  width 400
  type radio
}

#fieldTwo {
  width 200
}
