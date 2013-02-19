stylesheet demo {
  page "Age precondition" {
    question theAge {
      widget number[0., 125., 1.]
    }
    
    question theAge2 {
      widget slider[0., 125., 1.]
      width 400
      font "Arial"
      fontsize 14
      color #999999
      label-font "Comic Sans MS"
      label-fontsize 16
      label-color #2E31C2
    }
    
    question ofAge {
      widget checkbox
      font "Courier"
      fontsize 20
      color #FF0000
    }
    
    question ofAge2 {
      widget radio
      color #00AA00
    }
    
  }
  
  page "Information" {
    section "Too young" {
      question theAgeToYoung
    }
    
    section "Income" {
      question hourlyRate
      question lowRemark
      question averageRemark
      question highRemark
      question hoursAWeek
    }
    
  }
  
  page "Income overview" {
    question weeklyIncome {
      font "Arial"
      fontsize 14
      color #3C3C3C
    }
    
  }
  
  page "Date information" {
    question birthdate {
      widget text
    }
    question bornRemark
  }
  
  default integer {
    color #FF00FF
  }
  
}
