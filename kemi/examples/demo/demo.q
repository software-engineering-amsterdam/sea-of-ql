form demo { 
  "What is your age? The conditional is set at >= 18"
    integer theAge
  "Age again, but this time with a slider when styling is used"
    integer theAge2
  "Are you 18 or older? This is the second part of the conditional (ofAge == true)"
    boolean ofAge
  "And another of age, but with a radio button if styling is used."
    boolean ofAge2
  if( theAge >= 18 && 
      ofAge == true && 
      ofAge == ofAge2 && 
      theAge == theAge2) {
    // Apparantly, users of the form have to be 18 or older
    "Now, since you are 18 or older, the form can be started. What's your hourly rate on your job?"
      money hourlyRate
    if(hourlyRate <= 5) {
      "Bad: Your income is very low. Any remarks?"
        string lowRemark
    } else if (hourlyRate <= 15) {
      "OK: Your income is average. Any remarks?"
        string averageRemark    
    } else {
      "Great: Your income is very high. Any remarks?"
        string highRemark
    }
    "How many hours do you work in a week?"
      integer hoursAWeek
    "Fields can also be automatically calculated. This result is your weekly amount"
      money weeklyIncome = hourlyRate * hoursAWeek
    "What's your birthdate? Date is also an input format"
      date birthdate
    if(birthdate < $2000-01-01) {
      "You're born before the 1st of January 2000"
        string bornRemark
    }
  } else {
    "The conditional evaluated to false. You could be to young."
      boolean theAgeToYoung
  }
}
